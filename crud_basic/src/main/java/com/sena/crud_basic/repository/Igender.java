package com.sena.crud_basic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sena.crud_basic.model.Gender;

public interface Igender extends JpaRepository<Gender,Integer>{

    @Query("SELECT u FROM gender u WHERE u.status != false")
    List<Gender> getListGenderActive();

    @Query("SELECT u FROM gender u WHERE u.name LIKE %?1%")
    List<Gender> getListGenderForName(String filter);

    
}