package com.example.baozistore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.baozistore.model.Custumer;

@Repository
public interface CustumerRepository extends JpaRepository <Custumer, Long>{

}



