package com.changddao.ApiServer.entity.Item;

import com.changddao.ApiServer.entity.Item.Item;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@DiscriminatorValue("B")
@Entity
@Getter
@NoArgsConstructor
public class Book extends Item {
    private String author;
    private int page;

    public Book(String author, int page) {
        this.author = author;
        this.page = page;

    }
}
