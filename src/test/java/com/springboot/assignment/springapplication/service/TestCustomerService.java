package com.springboot.assignment.springapplication.service;

import com.springboot.assignment.springapplication.dao.CustomerRepository;
import com.springboot.assignment.springapplication.entity.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class TestCustomerService {

    @Autowired
    private CustomerService customerService;

    @MockBean
    private CustomerRepository customerRepository;

    @Test
    public void findAll(){
        when(customerRepository.findAll()).thenReturn(Stream.of(new Customer(1,"avinash","lokani","avinash.lokani@gmail.com"),
                new Customer(2,"raju","lee","raju.lee@gmail.com"),
                new Customer(3,"david","bam","david.bam@gmail.com"))
                .collect(Collectors.toList()));
        assertEquals(3, customerService.findAll().size());
    }
}
