package com.javanauts.code4me.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @GetMapping("/")
    @ResponseBody
    public String getHome(){
<<<<<<< Updated upstream
        return "index.html";
=======
        return "Proof of Life";
>>>>>>> Stashed changes
    }
}
