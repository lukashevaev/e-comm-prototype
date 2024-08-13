package com.bubusyaka.demo.controller;

import com.bubusyaka.demo.model.dto.Item;
import com.bubusyaka.demo.model.entity.ItemEntity;
import com.bubusyaka.demo.service.ItemService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    public List<Item> items() {
        List<Item> items = new ArrayList<>();

        return items;
    }

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/all")
    public List<Item> allItems() { // TODO change repo to service
        /*return itemRepository.findAll()
                .stream()
                .map(entity -> new Item(entity.getId(),entity.getName(),entity.getPrice()))
                .collect(Collectors.toList());*/

        return itemService.allItems();
    }

    @GetMapping("/name")
    public List<Item> getItemByName(@RequestParam String name) {
        return itemService.getItemByName(name);
    }

    @PostMapping
    public ItemEntity createNewItem(@RequestBody Item item) throws JsonProcessingException {
        return itemService.createNewItem(item);
    }

    @GetMapping("/cities")
    public List<Item> getItemsByProviderCityInNative(@RequestBody List<String> cities2) {
        return itemService.getItemsByProviderCityInNative(cities2);
    }
}
