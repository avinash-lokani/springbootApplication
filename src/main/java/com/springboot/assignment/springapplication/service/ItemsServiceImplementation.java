package com.springboot.assignment.springapplication.service;


import com.springboot.assignment.springapplication.dao.ItemsRepository;
import com.springboot.assignment.springapplication.entity.Item;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

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
    public Item findById(int id) throws RuntimeException {
        Optional<Item> result = itemsDAO.findById(id);
        Logger logger = Logger.getLogger(ItemsServiceImplementation.class.getName());
        Item items = null;

        try{
            if (result.isPresent()) {
                items = result.get();
            }

        }catch (Exception e){
            logger.info(e.getMessage());
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
