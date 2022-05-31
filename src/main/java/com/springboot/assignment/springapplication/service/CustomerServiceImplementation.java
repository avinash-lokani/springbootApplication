package com.springboot.assignment.springapplication.service;

import com.springboot.assignment.springapplication.dao.CustomerRepository;
import com.springboot.assignment.springapplication.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

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

    @Override
    public Customer findById(int id){
        Optional<Customer> result = customerDAO.findById(id);
        Logger logger = Logger.getLogger(ItemsServiceImplementation.class.getName());
        Customer customer = null;
        if (result.isPresent()) {
            customer = result.get();
        }
        else {
            logger.info("can not find item with id ="+id);
        }


        return customer;
    }
}
