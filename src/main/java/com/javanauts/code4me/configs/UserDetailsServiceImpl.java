package com.javanauts.code4me.configs;

import com.javanauts.code4me.models.AppUser;
import com.javanauts.code4me.repository.AppUserRepo;
import com.javanauts.code4me.repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    AppUserRepo appUserRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        return appUserRepo.findByUsername(username);
    }

}
