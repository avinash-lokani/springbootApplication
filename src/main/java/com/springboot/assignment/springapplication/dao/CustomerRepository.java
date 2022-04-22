package com.springboot.assignment.springapplication.dao;

import com.springboot.assignment.springapplication.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
