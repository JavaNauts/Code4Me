package com.javanauts.code4me.controller;

import com.javanauts.code4me.models.AppUser;
import com.javanauts.code4me.models.Profile;
import com.javanauts.code4me.models.Service;
import com.javanauts.code4me.models.Skill;
import com.javanauts.code4me.repository.AppUserRepo;
import com.javanauts.code4me.repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.ServletException;
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
    PasswordEncoder passwordEncoder;

    @Autowired
    HttpServletRequest request;

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
        if (p != null) {
            AppUser appUser = appUserRepo.findByUsername(username);
            m.addAttribute("appUser", appUser);
        }
        AppUser dbUser = appUserRepo.findByUsername(username);
        m.addAttribute("dbUserUsername", dbUser.getUsername());

        return "profile";
    }

    @PostMapping("/signup")
    public RedirectView createUser(String username, String password,
                                   String firstName, String lastName, String email){
        String hashedPassword = passwordEncoder.encode(password);
        AppUser newUser = new AppUser(username,hashedPassword,firstName,
                lastName,email);
        appUserRepo.save(newUser);
        return new RedirectView("/");
    }
    @PostMapping("/login")
    public RedirectView loginUser(String username, String password){
        AppUser appUserFromDb = appUserRepo.findByUsername(username);
        return new RedirectView("/");
    }
    @PostMapping("profile/{username}")
    public RedirectView editUserInfo(Model m, Principal p,
                                     @PathVariable String username, String bio,
                                     List<Skill> skills,
                                     List<Service> services, String gitHubLink
            , String projectOne, String projectOneDesc, String projectTwo,
                                     String projectTwoDesc,
                                     RedirectAttributes redir){
        if(p != null && p.getName().equals(username)){
            AppUser appUser = appUserRepo.findByUsername(username);
            Profile newProfile = appUser.getProfile();
            newProfile.setBio(bio);
            newProfile.setSkills(skills);
            newProfile.setServices(services);
            newProfile.setGitHubLink(gitHubLink);
            newProfile.setProjectOne(projectOne);
            newProfile.setProjectOneDesc(projectOneDesc);
            newProfile.setProjectTwo(projectTwo);
            newProfile.setProjectTwoDesc(projectTwoDesc);
            profileRepo.save(newProfile);
        } else {
            redir.addFlashAttribute("errorMessage", "Cannot edit another user's " +
                    "profile");
        }
        return new RedirectView("/profile/" + username);
    }
}
