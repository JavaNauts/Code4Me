package com.javanauts.code4me.repository;

import com.javanauts.code4me.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface ProfileRepo extends JpaRepository<Profile, Long> {

}
