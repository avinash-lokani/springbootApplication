package com.springboot.assignment.springapplication.dto;

import com.springboot.assignment.springapplication.entity.Customer;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

public @Data class ItemDto {

    private int id;
    private String name;
    private int price;
    private List<Customer> customers = new ArrayList<>();

}
