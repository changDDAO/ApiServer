package com.changddao.ApiServer.entity.Item;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="item_id")
    Long id;

    private String name;
    private int price;
    private int stockQuantity;

    public void addStock(int quantity) {
        this.stockQuantity+=quantity;
    }
    public void removeStock(int quantity) {
        int rest = this.stockQuantity -=quantity;
        if (rest < 0) {
            throw new IllegalStateException("need more stock");
        }
        this.stockQuantity = rest;
    }


}
