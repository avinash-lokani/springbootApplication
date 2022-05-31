package com.springboot.assignment.springapplication.service;


import com.springboot.assignment.springapplication.dao.ItemsRepository;
import com.springboot.assignment.springapplication.entity.Item;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ItemsServiceImplementation implements ItemsService {

    private ItemsRepository itemsDAO;

    public ItemsServiceImplementation(ItemsRepository itemsDAO) {
        this.itemsDAO = itemsDAO;
    }

    @Transactional
    @Override
    public List<Item> findAll() {
        return itemsDAO.findAll();
    }

    @Transactional
    @Override
    public Item findById(int id) throws RuntimeException {
        Optional<Item> result = itemsDAO.findById(id);
        Logger logger = Logger.getLogger(ItemsServiceImplementation.class.getName());
        Item items = null;

        if (result.isPresent()) {
            items = result.get();
        }
        else {
            logger.info("can not find item with id ="+id);
        }


        return items;
    }
    @Transactional
    @Override
    public void save(Item item) {
        itemsDAO.save(item);
    }
    @Transactional
    @Override
    public void deleteById(int id) {
        itemsDAO.deleteById(id);
    }
}
