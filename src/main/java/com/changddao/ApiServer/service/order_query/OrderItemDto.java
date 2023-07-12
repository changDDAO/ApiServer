package com.changddao.ApiServer.service.order_query;

import com.changddao.ApiServer.entity.OrderItem;
import lombok.Data;

@Data
public class OrderItemDto {
    String productName;
    int price;
    int count;

    public OrderItemDto(OrderItem orderItem) {
        this.productName = orderItem.getItem().getName();
        this.price = orderItem.getItem().getPrice();
        this.count = orderItem.getCount();
    }
}