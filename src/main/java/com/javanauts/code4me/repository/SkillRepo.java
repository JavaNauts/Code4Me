package com.javanauts.code4me.repository;

import com.javanauts.code4me.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepo extends JpaRepository<Skill, Long> {
    public Skill getSkillByKeyword(String keyword);
}
