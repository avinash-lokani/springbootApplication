package com.springboot.assignment.springapplication.dao;

import com.springboot.assignment.springapplication.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
