package com.changddao.ApiServer.controller;

import com.changddao.ApiServer.entity.Info;
import com.changddao.ApiServer.entity.Item.Book;
import com.changddao.ApiServer.entity.Member;
import com.changddao.ApiServer.entity.Order;
import com.changddao.ApiServer.entity.OrderItem;
import com.changddao.ApiServer.service.ItemService;
import com.changddao.ApiServer.service.MemberService;
import com.changddao.ApiServer.service.OrderService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DbInit {
    private final MemberService memberService;
    private final ItemService itemService;
    private final OrderService orderService;
    @PostConstruct
    public void init() {
        init1();
        init2();

    }
    public void init1() {
        Member member = new Member("changho", new Info("010-5057-8352","대구 수성구 황금동"));

        memberService.join(member);


        Book book1 = new Book("boner", 302);
        book1.setName("DDao Book1");
        book1.setStockQuantity(20);
        book1.setPrice(30000);

        Book book2 = new Book("ina Kim", 131);
        book2.setName("DDao Book2");
        book2.setPrice(50000);
        book2.setStockQuantity(170);
        itemService.saveItem(book1);
        itemService.saveItem(book2);

        OrderItem orderItem1 = OrderItem.createOrderItem(book1, 30000, 3);
        OrderItem orderItem2 = OrderItem.createOrderItem(book2, 50000, 7);

        Order order = Order.createOrder(member, orderItem1, orderItem2);
        orderService.saveOrder(order);


    }
    public void init2() {
        Book book1 = new Book("boner", 302);
        book1.setName("kimchi");
        book1.setStockQuantity(20);
        book1.setPrice(30000);

        Book book2 = new Book("ina Kim", 131);
        book2.setName("good");
        book2.setPrice(50000);
        book2.setStockQuantity(170);
        itemService.saveItem(book1);
        itemService.saveItem(book2);

        OrderItem orderItem1 = OrderItem.createOrderItem(book1, 30000, 11);
        OrderItem orderItem2 = OrderItem.createOrderItem(book2, 50000, 14);
        Member member2 = new Member("jongho", new Info("010-8771-8352","대구 수성구 황금동"));


        memberService.join(member2);

        Order order = Order.createOrder(member2, orderItem1, orderItem2);
        orderService.saveOrder(order);


    }
}
