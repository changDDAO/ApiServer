package com.changddao.ApiServer.entity;

import com.changddao.ApiServer.entity.Item.Item;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    private int orderPrice;
    private int count;

    public void setOrder(Order order) {
        this.order = order;
    }
    public void cancel() {
        this.getItem().addStock(count);
    }
    public int getTotalPrice() {
        return this.orderPrice*count;
    }

        //생성 메서드
    public static OrderItem createOrderItem(Item item, int orderPrice, int count) {
        OrderItem orderItem = new OrderItem();
        orderItem.item= item;
        orderItem.orderPrice=orderPrice;
        orderItem.count =count;
        item.removeStock(count);
        return orderItem;
    }
}
