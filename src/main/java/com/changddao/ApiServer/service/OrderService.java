package com.changddao.ApiServer.service;

import com.changddao.ApiServer.entity.Item.Item;
import com.changddao.ApiServer.entity.Member;
import com.changddao.ApiServer.entity.Order;
import com.changddao.ApiServer.entity.OrderItem;
import com.changddao.ApiServer.repository.ItemRepository;
import com.changddao.ApiServer.repository.MemberRepository;
import com.changddao.ApiServer.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public Long saveOrder(Order order) {
        Order save = orderRepository.save(order);
        return save.getId();
    }

    public Long order(Member member, Item item, int count) {
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);
        Order order = Order.createOrder(member, orderItem);
        Order savedOrder = orderRepository.save(order);
        return savedOrder.getId();

    }
    public void cancelOrder(Order order) {
        order.cancel();
    }

    public List<Order> findOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders;
    }

}
