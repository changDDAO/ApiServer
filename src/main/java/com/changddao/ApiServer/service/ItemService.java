package com.changddao.ApiServer.service;

import com.changddao.ApiServer.entity.Item.Item;
import com.changddao.ApiServer.repository.ItemRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public void saveItem(Item item) {
        itemRepository.save(item);
    }
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item findItem(Long id) {
        Item item = itemRepository.findById(id).orElse(null);
        return item;
    }


}
