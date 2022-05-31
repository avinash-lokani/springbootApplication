package com.springboot.assignment.springapplication.Controller;


import com.springboot.assignment.springapplication.converter.CustomerConverter;
import com.springboot.assignment.springapplication.dto.CustomerDto;
import com.springboot.assignment.springapplication.entity.Customer;
import com.springboot.assignment.springapplication.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomersListController {

    private CustomerService customerService;

    @Autowired
    private CustomerConverter converter;

    public CustomersListController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/list")
    public String customersList(Model model){

        List<Customer> customersList = customerService.findAll();

        List<CustomerDto> customersDtoList = converter.customerEntityToDto(customersList);

        model.addAttribute("customers",customersDtoList);
        return "customer-list";
    }

    @Override
    public String toString() {
        return "GetCustomersController{" +
                "customerService=" + customerService +
                '}';
    }
}
