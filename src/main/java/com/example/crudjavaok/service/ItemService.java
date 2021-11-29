package com.example.crudjavaok.service;

import com.example.crudjavaok.entity.Item;
import com.example.crudjavaok.in.ItemIn;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface ItemService {
    Map<String, Object> getAll(Pageable pageable, String textSearch);
    Item create(ItemIn itemIn);
    Item update(Integer id, ItemIn itemIn);
    Item getID(Integer id);
    Map<String, Object>delete(Integer id);
}
