package com.springboot.assignment.springapplication.converter;

import com.springboot.assignment.springapplication.dto.CustomerDto;
import com.springboot.assignment.springapplication.dto.ItemDto;
import com.springboot.assignment.springapplication.entity.Customer;
import com.springboot.assignment.springapplication.entity.Item;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemsConverter {

    public ItemDto itemEntityToDto(Item item){
        ItemDto itemDto = new ItemDto();
        itemDto.setId(item.getId());
        item.setCustomers(item.getCustomers());
        itemDto.setName(item.getName());
        itemDto.setPrice(item.getPrice());

        return itemDto;
    }

    public List<ItemDto> itemEntityToDto(List<Item> itemList){
        return itemList.stream().map(x -> itemEntityToDto(x)).collect(Collectors.toList());
    }

    public Item itemDtoToEntity(ItemDto itemDto){
        Item item = new Item();
        item.setName(itemDto.getName());
        item.setId(item.getId());
        item.setPrice(itemDto.getPrice());
        item.setCustomers(itemDto.getCustomers());

        return item;
    }

    public List<Item> itemDtoToEntity(List<ItemDto> itemDtoList){
        return itemDtoList.stream().map(x -> itemDtoToEntity(x)).collect(Collectors.toList());
    }
}
