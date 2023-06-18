package com.changddao.ApiServer.controller;

import com.changddao.ApiServer.entity.Order;
import com.changddao.ApiServer.entity.OrderItem;
import com.changddao.ApiServer.service.OrderService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class OrderApiController {
    private final OrderService orderService;
   @GetMapping("/api/v2/orders")
    public List<OrderFetchedDto> ordersV2() {
       List<Order> orders = orderService.ordersWithMember();
       List<OrderFetchedDto> collect = orders.stream().map(order -> new OrderFetchedDto(order))
               .collect(Collectors.toList());
       return collect;
   }
    @Data
    private class OrderFetchedDto{
       String username;
       String phoneNum;
       LocalDateTime orderTime;
       public List<OrderItemDto> orderItems;
       //entity를 직접 노출하면 안된다
        // entity를 수정하는 경우 api스펙자체가 깨지기 때문에 entity는 무조건
        //dto로 변환하여 반환하자

        public OrderFetchedDto(Order order) {
            this.username =order.getMember().getUsername();
            this.phoneNum = order.getMember().getInfo().getPhoneNumber();
            this.orderTime = order.getCreatedDate();
            this.orderItems = order.getOrderItems().stream()
                    .map(orderItem->new OrderItemDto(orderItem))
                    .collect(Collectors.toList());
        }
        @Data
        private class OrderItemDto {
            String productName;
            int price;
            int count;

            public OrderItemDto(OrderItem orderItem) {
                this.productName =orderItem.getItem().getName();
                this.price = orderItem.getItem().getPrice();
                this.count = orderItem.getCount();
            }
        }
    }
}
