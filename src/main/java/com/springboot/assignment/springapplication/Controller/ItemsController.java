package com.springboot.assignment.springapplication.Controller;

import com.springboot.assignment.springapplication.converter.ItemsConverter;
import com.springboot.assignment.springapplication.dto.ItemDto;
import com.springboot.assignment.springapplication.entity.Item;
import com.springboot.assignment.springapplication.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ItemsConverter converter;

    private String form = "items-form";

    public ItemsController(ItemsService itemsService) {
        this.itemsService = itemsService;
    }

    @GetMapping("/list")
    public String listItems(Model model){

        List<Item> itemList = itemsService.findAll();

        List<ItemDto> itemDtoList = converter.itemEntityToDto(itemList);

        model.addAttribute("items",itemDtoList);
        return "list-items";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        ItemDto itemDto = new ItemDto();

        model.addAttribute("item",itemDto);
        return form;
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("item") ItemDto itemDto,
                       BindingResult bindingResult,Model model){

        if(bindingResult.hasErrors()){
            model.addAttribute("item",itemDto);
            return form;
        }
        else {
            Item item = converter.itemDtoToEntity(itemDto);
            itemsService.save(item);
            return "redirect:/";
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
        return "redirect:/";
    }

    @GetMapping("/access-denied")
    public String accessDenied(){
        return "access-denied";
    }
}
