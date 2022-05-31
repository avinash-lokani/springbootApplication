package com.springboot.assignment.springapplication.dto;


import com.springboot.assignment.springapplication.entity.Item;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

public @Data class CustomerDto {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private List<Item> items = new ArrayList<>();

}
