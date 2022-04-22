package com.springboot.assignment.springapplication.service;

import com.springboot.assignment.springapplication.dao.ItemsRepository;
import com.springboot.assignment.springapplication.entity.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestItemsService {

    @Autowired
    private ItemsService itemsService;

    @MockBean
    private ItemsRepository itemsRepository;

    @Test
    public void findAll(){
        when(itemsRepository.findAll()).thenReturn(Stream.of(new Item(1,"pen",20),
                new Item(2,"book",50),
                new Item(3,"chocolate",30),
                new Item(4,"box",10),
                new Item(5,"banana",20)).collect(Collectors.toList()));
        assertEquals(5, itemsService.findAll().size());
    }

    @Test
    public void findById(){
        Item item = new Item(1,"pen",20);

        when(itemsRepository.findById(1)).thenReturn(Optional.of(item));

        assertEquals(item, itemsService.findById(1));
    }

    @Test
    public void save(){
        Item item = new Item("pen",20);
        itemsService.save(item);
        when(itemsRepository.findById(6)).thenReturn(Optional.of(item));
        assertEquals(item, itemsService.findById(6));
    }

    @Test
    public void delete(){
        itemsService.deleteById(1);
        verify(itemsRepository, times(1)).deleteById(1);
    }
}
