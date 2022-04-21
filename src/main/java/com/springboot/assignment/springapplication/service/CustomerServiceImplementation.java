package com.springboot.assignment.springapplication.service;

import com.springboot.assignment.springapplication.dao.CustomerRepository;
import com.springboot.assignment.springapplication.dao.ItemsRepository;
import com.springboot.assignment.springapplication.entity.Customer;
import com.springboot.assignment.springapplication.entity.Item;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImplementation implements CustomerService{

    private CustomerRepository customerDAO;

    public CustomerServiceImplementation(CustomerRepository customerDAO) {
        this.customerDAO = customerDAO;
    }


    @Override
    public List<Customer> findAll() {
        return customerDAO.findAll();
    }
}
