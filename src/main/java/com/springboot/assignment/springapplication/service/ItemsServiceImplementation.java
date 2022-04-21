package com.springboot.assignment.springapplication.service;


import com.springboot.assignment.springapplication.dao.ItemsRepository;
import com.springboot.assignment.springapplication.entity.Item;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemsServiceImplementation implements ItemsService {

    private ItemsRepository itemsDAO;

    public ItemsServiceImplementation(ItemsRepository itemsDAO) {
        this.itemsDAO = itemsDAO;
    }

    @Override
    public List<Item> findAll() {
        return itemsDAO.findAll();
    }

    @Override
    public Item findById(int id) {
        Optional<Item> result = itemsDAO.findById(id);

        Item items = null;

        if (result.isPresent()) {
            items = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + id);
        }

        return items;
    }

    @Override
    public void save(Item item) {
        itemsDAO.save(item);
    }

    @Override
    public void deleteById(int id) {
        itemsDAO.deleteById(id);
    }
}
