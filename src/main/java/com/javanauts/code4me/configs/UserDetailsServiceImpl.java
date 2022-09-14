package com.javanauts.code4me.configs;

import com.javanauts.code4me.repository.AppUserRepo;
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
<<<<<<< Updated upstream
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        return (UserDetails) appUserRepo.findByUsername(username);
=======
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return appUserRepo.findByUsername(username);
>>>>>>> Stashed changes
    }

}
