package com.springboot.assignment.springapplication.Controller;


import com.springboot.assignment.springapplication.entity.Customer;
import com.springboot.assignment.springapplication.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/get")
public class GetCustomersController {

    private CustomerService customerService;

    public GetCustomersController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public String customersList(Model model){

        List<Customer> customers = customerService.findAll();

        model.addAttribute("customers",customers);
        return "customer-list";
    }

    @Override
    public String toString() {
        return "GetCustomersController{" +
                "customerService=" + customerService +
                '}';
    }
}
