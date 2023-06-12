package com.changddao.ApiServer.repository;

import com.changddao.ApiServer.entity.Item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
