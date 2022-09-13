package com.javanauts.code4me.controller;

import com.javanauts.code4me.models.AppUser;
import com.javanauts.code4me.repository.AppUserRepo;
import com.javanauts.code4me.repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {

    @Autowired
    AppUserRepo appUserRepo;

    @Autowired
    ProfileRepo profileRepo;

//    @Autowired
//    PasswordEncoder passwordEncoder;
//
    @GetMapping("/")
    public String getHome(){
        return "index";
    }

    @GetMapping("/signup")
    public String getSignup(){
        return "signup";
    }

    @PostMapping("/signup")
    public RedirectView createUser(String userName, String password, String email,
                                   String firstName, String lastName){
//        String hashedPassword = passwordEncoder.encode(password);
        AppUser newUser = new AppUser(userName,password, email, firstName,
                lastName);
        appUserRepo.save(newUser);
        return new RedirectView("/");
    }
}
