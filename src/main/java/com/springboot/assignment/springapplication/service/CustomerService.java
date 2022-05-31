package com.springboot.assignment.springapplication.service;

import com.springboot.assignment.springapplication.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> findAll();

    Customer findById(int id);
}
