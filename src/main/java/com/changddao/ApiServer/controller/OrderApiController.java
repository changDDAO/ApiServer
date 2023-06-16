package com.changddao.ApiServer.controller;

import com.changddao.ApiServer.entity.Order;
import com.changddao.ApiServer.entity.OrderItem;
import com.changddao.ApiServer.service.OrderService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderApiController {
    private final OrderService orderService;
    @GetMapping("api/v3/orders")
    public List<OrderQueryDto> ordersWithMemberResponse() {
        return null; //작업해야될 부분들
    }
    @Data
    static class OrderQueryDto{
        private String memberName;
        private List<OrderItem> orderItems;
    }
}
