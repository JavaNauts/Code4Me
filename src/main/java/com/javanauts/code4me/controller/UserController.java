package com.javanauts.code4me.controller;

import com.javanauts.code4me.models.AppUser;
import com.javanauts.code4me.repository.AppUserRepo;
import com.javanauts.code4me.repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

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
            AppUser appUser = appUserRepo.findByUsername(username);
            m.addAttribute("appUser", appUser);
        }
        return "signup";
    }

    @GetMapping("/login")
    public String getLoginPage(){return "login"; }

    @PostMapping("/signup")
    public RedirectView createUser(String username, String password, String email,
                                   String firstName, String lastName){
        String hashedPassword = passwordEncoder.encode(password);
        AppUser newUser = new AppUser(username,hashedPassword, email, firstName,
                lastName);
        appUserRepo.save(newUser);
        return new RedirectView("/");
    }
    @PostMapping("/login")
    public RedirectView loginUser(String username, String password){
        AppUser appUserFromDb = (AppUser) appUserRepo.findByUsername(username);
        return new RedirectView("/");
    }
}
