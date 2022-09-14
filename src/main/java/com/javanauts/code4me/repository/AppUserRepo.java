package com.javanauts.code4me.repository;

import com.javanauts.code4me.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface AppUserRepo extends JpaRepository<AppUser, Long> {
    public UserDetails findByUsername(String username);
}
