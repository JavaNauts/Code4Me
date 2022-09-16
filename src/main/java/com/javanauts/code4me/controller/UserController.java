package com.javanauts.code4me.controller;

import com.javanauts.code4me.models.AppUser;
import com.javanauts.code4me.models.Profile;
import com.javanauts.code4me.models.Service;
import com.javanauts.code4me.models.Skill;
import com.javanauts.code4me.repository.AppUserRepo;
import com.javanauts.code4me.repository.ProfileRepo;
import com.javanauts.code4me.repository.ServiceRepo;
import com.javanauts.code4me.repository.SkillRepo;
import com.javanauts.code4me.service.ChargeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    AppUserRepo appUserRepo;
    @Autowired
    ProfileRepo profileRepo;

    @Autowired
    SkillRepo skillRepo;

    @Autowired
    ServiceRepo serviceRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Value("${STRIPE_PUBLIC_KEY}")
    private String stripePublicKey;

    @GetMapping("/")
    public String getHome(Principal p, Model m){
        if(p != null){
            String username = p.getName();
            m.addAttribute("username", username);
        }
        return "index";
    }

    @GetMapping("/signup")
    public String getSignup(Principal p, Model m){
        if(p != null){
            String username = p.getName();
            AppUser appUser = (AppUser) appUserRepo.findByUsername(username);
            m.addAttribute("appUser", appUser);
        }
        return "signup";
    }
    @GetMapping("/login")
    public String getLoginPage(){return "login"; }

    @GetMapping("/profile/{username}")
    public String getUserProfile(Principal p, Model m,
                                 @PathVariable String username) {

        AppUser dbUser = appUserRepo.findByUsername(username);
        m.addAttribute("dbUser", dbUser);

        List<Service> services = dbUser.getProfile().services;
        m.addAttribute("services", services);

        m.addAttribute("stripePublicKey",stripePublicKey);
        m.addAttribute("currency", ChargeRequest.Currency.USD);


        return "profile";
    }

    @GetMapping("/edit-profile/{username}")
    public String getEditPage(Principal p, Model m, @PathVariable String username){
        boolean formEnabled = false;
        if (p != null) {
            formEnabled = true;
            AppUser appUser = appUserRepo.findByUsername(username);
            m.addAttribute("appUser", appUser);
            m.addAttribute("formEnabled", true);
        }
        AppUser dbUser = appUserRepo.findByUsername(username);
        m.addAttribute("dbUser", dbUser);
        return "edit-profile";
    }

    @PostMapping("/signup")
    public RedirectView createUser(String username, String password,
                                   String firstName, String lastName, String email){
        String hashedPassword = passwordEncoder.encode(password);
        Profile newProfile = new Profile("Enter bio here","example@github.com", "Give a project title here", "Project Description", "Give a project link here",
                "Give a project title here","Project description", "Project link");
        AppUser newUser = new AppUser(username,hashedPassword,firstName,
                lastName,email, newProfile);
        profileRepo.save(newProfile);
        appUserRepo.save(newUser);
        return new RedirectView("/");
    }
    @PostMapping("/login")
    public RedirectView loginUser(String username, String password){
        AppUser appUserFromDb = appUserRepo.findByUsername(username);
        return new RedirectView("/");
    }

    @PostMapping("edit-profile/{username}")
    public RedirectView editUserInfo(Model m, Principal p,
                                     @PathVariable String username, String bio,
                                     String gitHubLink, String projectOne, String projectOneDesc,
                                     String projectOneLink,String projectTwo,
                                     String projectTwoDesc,String projectTwoLink,
                                     RedirectAttributes redir){
        if(p != null && p.getName().equals(username)){
            AppUser appUser = appUserRepo.findByUsername(username);
            Profile newProfile = appUser.getProfile();
            newProfile.setBio(bio);
            newProfile.setGitHubLink(gitHubLink);
            newProfile.setProjectOne(projectOne);
            newProfile.setProjectOneDesc(projectOneDesc);
            newProfile.setProjectOneLink(projectOneLink);
            newProfile.setProjectTwo(projectTwo);
            newProfile.setProjectTwoDesc(projectTwoDesc);
            newProfile.setProjectTwoLink(projectTwoLink);
            profileRepo.save(newProfile);
        } else {
            redir.addFlashAttribute("errorMessage", "Cannot edit another user's " +
                    "profile");
        }
        return new RedirectView("/edit-profile/" + username);
    }

    @PostMapping("edit-skills/{username}")
    public RedirectView editSkills(Model m, Principal p,
                                     @PathVariable String username,
                                     String WebDevelopment,String ServerDevelopment,String Webdesign, String FullStack,String ApplicationDevelopment,String Mobile){

        if(p != null && p.getName().equals(username)){
            AppUser appUser = appUserRepo.findByUsername(username);
            Profile userProfile = profileRepo.findByAppUser(appUser);
            List<Skill> skillList = new ArrayList<>();
            skillList.add(new Skill(WebDevelopment, userProfile));
            skillList.add(new Skill(ServerDevelopment, userProfile));
            skillList.add(new Skill(Webdesign, userProfile));
            skillList.add(new Skill(FullStack, userProfile));
            skillList.add(new Skill(ApplicationDevelopment, userProfile));
            skillList.add(new Skill(Mobile, userProfile));
            skillRepo.saveAll(skillList);
        }
        return new RedirectView("/edit-profile/" + username);
    }
    @PostMapping("edit-services/{username}")
    public RedirectView editServices(Model m, Principal p,
                                   @PathVariable String username, String title,
                                   String description, int price){

        if(p != null && p.getName().equals(username)){
            AppUser appUser = appUserRepo.findByUsername(username);
            Profile newProfile = profileRepo.findByAppUser(appUser);
            Service newService = new Service(description,title,price, newProfile);
           serviceRepo.save(newService);
        }
        return new RedirectView("/edit-profile/" + username);
    }

}
