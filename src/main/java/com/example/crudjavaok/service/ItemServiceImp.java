package com.example.crudjavaok.service;

import com.example.crudjavaok.Repository.ItemRepository;
import com.example.crudjavaok.entity.Item;
import com.example.crudjavaok.in.ItemIn;
import com.example.crudjavaok.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ItemServiceImp implements ItemService{
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Map<String, Object> getAll(Pageable pageable, String textSearch) {
        Page<Item>list;
        list=itemRepository.findAllByNameContaining(pageable, textSearch);
        Map<String,Object>respon = new HashMap<>();
        respon.put("result", list.getContent());
        respon.put("totalPage", list.getTotalPages());
        return respon;
    }

    @Override
    public Item create(ItemIn itemIn) {
        Item item = ItemMapper.map(itemIn);
        return itemRepository.save(item);
    }

    @Override
    public Item update(Integer id, ItemIn itemIn) {
        Item item = itemRepository.findItemById(id);
        item.setId(id);
        item.setName(itemIn.getName());
        return itemRepository.save(item);
    }

    @Override
    public Item getID(Integer id) {
        Item item = itemRepository.findItemById(id);
        return item;
    }

    @Override
    public Map<String, Object> delete(Integer id) {
        Item item = itemRepository.findItemById(id);
        itemRepository.delete(item);
        Map<String, Object> repon = new HashMap<>();
        repon.put("result", "ok");
        return repon;
    }
}
