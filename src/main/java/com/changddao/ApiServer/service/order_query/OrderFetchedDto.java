package com.changddao.ApiServer.service.order_query;

import com.changddao.ApiServer.entity.Order;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
    public class OrderFetchedDto {
    String username;
    String phoneNum;
    LocalDateTime orderTime;
    public List<OrderItemDto> orderItems;
    //entity를 직접 노출하면 안된다
    // entity를 수정하는 경우 api스펙자체가 깨지기 때문에 entity는 무조건
    //dto로 변환하여 반환하자

    public OrderFetchedDto(Order order) {
        this.username = order.getMember().getUsername();
        this.phoneNum = order.getMember().getInfo().getPhoneNumber();
        this.orderTime = order.getCreatedDate();
        this.orderItems = order.getOrderItems().stream()
                .map(orderItem -> new OrderItemDto(orderItem))
                .collect(Collectors.toList());
    }
}