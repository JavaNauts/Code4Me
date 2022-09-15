package com.javanauts.code4me.repository;

import com.javanauts.code4me.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepo extends JpaRepository<Service, Long> {

}
