package com.changddao.ApiServer.service.order_query;

import com.changddao.ApiServer.entity.Order;
import com.changddao.ApiServer.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderQueryService {
    private final OrderService orderService;
    public List<OrderFetchedDto> OrderV4(){
        List<Order> orders = orderService.ordersWithItem();
        List<OrderFetchedDto> collect = orders.stream().map(order -> new OrderFetchedDto(order))
                .collect(Collectors.toList());
        return collect;
    }
}
