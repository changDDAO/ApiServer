package com.changddao.ApiServer.repository;

import com.changddao.ApiServer.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
