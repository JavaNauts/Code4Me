package com.javanauts.code4me.repository;

import com.javanauts.code4me.models.clientUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientUser extends JpaRepository<clientUser, Long> {

    public clientUser findByUserName(String userName);

}
