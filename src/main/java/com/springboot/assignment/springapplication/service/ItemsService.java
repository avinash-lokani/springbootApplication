package com.springboot.assignment.springapplication.service;

import com.springboot.assignment.springapplication.entity.Item;

import java.util.List;

public interface ItemsService {
    public List<Item> findAll();

    public Item findById(int id);

    public void save(Item item);

    public void deleteById(int id);
}
