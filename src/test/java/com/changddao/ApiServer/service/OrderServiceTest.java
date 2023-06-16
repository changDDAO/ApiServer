package com.changddao.ApiServer.service;

import com.changddao.ApiServer.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OrderServiceTest {
    @Autowired
    OrderService orderService;
    @Test
    public void 주문fetchjoin_test(){
    //given
        List<Order> orders = orderService.ordersWithMember();
        for (Order order : orders) {
            System.out.println(order.getMember().getUsername());
        }

        //when



    //then


    }

}