package com.example.crudjavaok.mapper;

import com.example.crudjavaok.dto.ItemDto;
import com.example.crudjavaok.entity.Item;
import com.example.crudjavaok.in.ItemIn;

public class ItemMapper {
    public static Item map(ItemIn itemIn){
        Item item=new Item();
        item.setName(itemIn.getName());
        return item;
    }

    public static ItemDto map(Item item){
        ItemDto itemDto = new ItemDto();
        itemDto.setId(item.getId());
        itemDto.setName(item.getName());
        return itemDto;
    }
}
