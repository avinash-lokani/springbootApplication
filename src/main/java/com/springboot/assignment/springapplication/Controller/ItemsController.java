package com.springboot.assignment.springapplication.Controller;

import com.springboot.assignment.springapplication.entity.Item;
import com.springboot.assignment.springapplication.service.ItemsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/items")
public class ItemsController {

    private ItemsService itemsService;

    private String form = "items-form";

    public ItemsController(ItemsService itemsService) {
        this.itemsService = itemsService;
    }

    @GetMapping("/list")
    public String listItems(Model model){

        List<Item> itemList = itemsService.findAll();

        model.addAttribute("items",itemList);
        return "list-items";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        Item item = new Item();
        model.addAttribute("item",item);
        return form;
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("item") Item item,
                       BindingResult bindingResult,Model model){

        if(bindingResult.hasErrors()){
            model.addAttribute("item",item);
            return form;
        }
        else {
            itemsService.save(item);
            return "redirect:/items/list";
        }
    }

    @GetMapping("/showFromForUpdate")
    public String showFromForUpdate(@RequestParam("itemId") int id,
                                    Model model){
        Item item = itemsService.findById(id);
        model.addAttribute("item",item);
        return form;
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("itemId") int id){
        itemsService.deleteById(id);

        return "redirect:/items/list";
    }
}
