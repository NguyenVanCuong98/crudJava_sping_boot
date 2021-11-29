package com.example.crudjavaok.Repository;

import com.example.crudjavaok.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    Item findItemById(Integer id);
    Page<Item> findAll(Pageable pageable);
    Page<Item> findAllByNameContaining(Pageable pageable, String textSearch);

}
