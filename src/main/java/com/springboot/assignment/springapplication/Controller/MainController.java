package com.springboot.assignment.springapplication.Controller;

import com.springboot.assignment.springapplication.Exceptions.ItemNotFoundException;
import com.springboot.assignment.springapplication.entity.Item;
import com.springboot.assignment.springapplication.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ItemsService itemsService;

    private List<Item> itemList;
    private List<Item> cartList = new ArrayList<>();

    public MainController(ItemsService itemsService){
        this.itemsService = itemsService;
    }


    @GetMapping("/")
    public String showHome(Model model,Principal principal){


        itemList = itemsService.findAll();

        model.addAttribute("items",itemList);

        return "home";
    }

    @GetMapping("/items/list/addCart")
    public String buyItems(@RequestParam("itemId") int item_id,
                           Model model){

        Item item = itemsService.findById(item_id);
        cartList.add(item);
        model.addAttribute("carts",cartList);

        if(item == null || item_id < 0){
            throw new ItemNotFoundException("item id not found -"+item_id);
        }
        return "carts";
    }


}
