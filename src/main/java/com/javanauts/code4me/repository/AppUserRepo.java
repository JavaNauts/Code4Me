package com.javanauts.code4me.repository;

import com.javanauts.code4me.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser, Long> {
    public AppUser findByUsername(String username);
}
