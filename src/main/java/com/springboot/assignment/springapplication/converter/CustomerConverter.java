package com.springboot.assignment.springapplication.converter;

import com.springboot.assignment.springapplication.dto.CustomerDto;
import com.springboot.assignment.springapplication.entity.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerConverter {

    public CustomerDto customerEntityToDto(Customer customer){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setEmail(customer.getEmail());
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setId(customer.getId());
        customerDto.setItems(customer.getItems());
        customerDto.setLastName(customer.getLastName());
        return customerDto;
    }

    public List<CustomerDto> customerEntityToDto(List<Customer> customerList){
        return customerList.stream().map(x -> customerEntityToDto(x)).collect(Collectors.toList());
    }

    public Customer customerDtoToEntity(CustomerDto customerDto){
        Customer customer = new Customer();
        customer.setEmail(customerDto.getEmail());
        customer.setId(customerDto.getId());
        customer.setItems(customerDto.getItems());
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());

        return customer;
    }

    public List<Customer> customerDtoToEntity(List<CustomerDto> customerDtoList){
        return customerDtoList.stream().map(x -> customerDtoToEntity(x)).collect(Collectors.toList());
    }

}
