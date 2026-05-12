package com.example.baozistore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.baozistore.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository <Customer, Long>{

}



