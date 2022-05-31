package com.springboot.assignment.springapplication.service;

import com.springboot.assignment.springapplication.dao.CustomerRepository;
import com.springboot.assignment.springapplication.entity.Customer;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class TestCustomerService {

    @Autowired
    private CustomerService customerService;

    @MockBean
    private CustomerRepository customerRepository;

    @Test
     void findAll(){

        List<Customer> customerList = new ArrayList<>();

        Customer customer = new Customer(1,"avinash","lokani","avinash.lokani@gmail.com");
        customerList.add(customer);

        when(customerRepository.findAll()).thenReturn(customerList);
        assertEquals(1,customerService.findAll().size());


    }
}
