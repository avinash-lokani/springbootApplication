package com.springboot.assignment.springapplication.Controller;

import com.springboot.assignment.springapplication.entity.Customer;
import com.springboot.assignment.springapplication.entity.Item;
import com.springboot.assignment.springapplication.service.CustomerService;
import com.springboot.assignment.springapplication.service.ItemsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private ItemsService itemsService;



    public CustomerController(ItemsService itemsService) {
        this.itemsService = itemsService;
    }

    @GetMapping("/list")
    public String listItems(Model model){

        List<Item> itemList = itemsService.findAll();

        model.addAttribute("items",itemList);

        return "customer-items-list";
    }
    @GetMapping("/buy")
    public String buy(@RequestParam("itemId") int item_id,
                                    Model model){

        Item item = itemsService.findById(item_id);
        model.addAttribute("item",item);
        System.out.println(item);

        return "customer-conformation";
    }
//login-registration-jdbc
}
