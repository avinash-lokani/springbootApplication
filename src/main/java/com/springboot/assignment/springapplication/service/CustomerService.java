package com.springboot.assignment.springapplication.service;

import com.springboot.assignment.springapplication.entity.Customer;
import com.springboot.assignment.springapplication.entity.Item;

import java.util.List;

public interface CustomerService {

    public List<Customer> findAll();

}
