package com.changddao.ApiServer.repository;

import com.changddao.ApiServer.entity.Order;
import com.changddao.ApiServer.entity.OrderItem;

import java.util.List;

public interface OrderRepositoryCustom {
    public List<Order> ordersWithMember();

    public List<Order> findOrdersWithItem();


}
