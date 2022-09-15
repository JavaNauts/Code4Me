package com.javanauts.code4me.repository;

import com.javanauts.code4me.models.AppUser;
import com.javanauts.code4me.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface ProfileRepo extends JpaRepository<Profile, Long> {
    public Profile findByAppUser(AppUser appUser);
    public Profile findById(long id);
}
