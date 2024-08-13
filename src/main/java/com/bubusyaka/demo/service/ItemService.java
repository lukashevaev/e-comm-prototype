package com.bubusyaka.demo.service;

import com.bubusyaka.demo.model.dto.Item;
import com.bubusyaka.demo.model.entity.ItemEntity;
import com.bubusyaka.demo.repository.jpa.ItemRepository;
import com.bubusyaka.demo.repository.jpa.ProviderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final ProviderRepository providerRepository;

    public List<Item> allItems() {

        return itemRepository.findAll()
                .stream()
                .map(entity -> new Item(entity.getId(), entity.getName(), entity.getPrice(), entity.getProviderId()))
                .collect(Collectors.toList());
    }

    public List<Item> getItemByName(String name){

        return  itemRepository.findByName(name)
                .stream()
                .map(entity -> new Item((entity.getId()), entity.getName(), entity.getPrice(), entity.getProviderId()))
                .collect(Collectors.toList());
    }

    public ItemEntity createNewItem(Item item) {
        return providerRepository.findById(item.getProviderId())
                .map(provider -> {
                    var entity = new ItemEntity(item.getName(), item.getPrice(), item.getProviderId());
                    entity.setId(item.getId());
                    return entity;

                })
                .map(entity -> itemRepository.save(entity))
                .orElseThrow(() -> new RuntimeException("Provider not found"));
    }

    public List<Item> getItemsByProviderCityInNative(List<String> city) {
        return itemRepository.findItemsByProviderCityInNative(city)
                .stream()
                .map(entity -> new Item((entity.getId()), entity.getName(), entity.getPrice(), entity.getProviderId()))
                .collect(Collectors.toList());
    }
}
