package com.javanauts.code4me.controller;

import com.javanauts.code4me.models.Skill;
import com.javanauts.code4me.repository.AppUserRepo;
import com.javanauts.code4me.repository.SkillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    SkillRepo skillRepo;

    @PostMapping("/search-skills")
    public RedirectView searchSkills(String keyword) {
        return new RedirectView("/Skills-Results/" + keyword);
    }

    @GetMapping("/Skills-Results/{keyword}")
    public String displaySearchResults(Model m, @PathVariable String keyword){
        List<Skill> skills = skillRepo.getSkillsByKeyword(keyword);
        m.addAttribute("skills", skills);
        return "SkillsResults";
    }
}
