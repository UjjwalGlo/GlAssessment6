package com.ujjwal.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import com.ujjwal.demo.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> 
{

}
