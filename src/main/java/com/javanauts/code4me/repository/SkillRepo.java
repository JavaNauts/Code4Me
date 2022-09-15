package com.javanauts.code4me.repository;

import com.javanauts.code4me.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SkillRepo extends JpaRepository<Skill, Long> {
    @Query(value="SELECT * FROM public.skill WHERE keyword LIKE ?1",nativeQuery = true)
    List<Skill> getSkillsByKeyword(String keyword);


}
