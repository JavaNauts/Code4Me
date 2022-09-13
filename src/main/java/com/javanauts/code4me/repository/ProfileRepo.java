package com.javanauts.code4me.repository;

import com.javanauts.code4me.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepo extends JpaRepository<Profile, Long> {
}
