package com.javanauts.code4me.repository;

import com.javanauts.code4me.models.devUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DevRepo extends JpaRepository<devUser, Long> {

    public  devUser findByUserName(String userName);


}
