package com.changddao.ApiServer.repository;

import com.changddao.ApiServer.entity.Order;
import com.changddao.ApiServer.entity.QMember;
import com.changddao.ApiServer.entity.QOrder;
import com.querydsl.core.QueryFactory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.List;

import static com.changddao.ApiServer.entity.QMember.*;
import static com.changddao.ApiServer.entity.QOrder.*;

public class OrderRepositoryImpl implements OrderRepositoryCustom{
    JPAQueryFactory queryFactory;

    public OrderRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Order> ordersWithMember() {
        List<Order> result = queryFactory.selectFrom(order)
                .leftJoin(order.member,member).fetchJoin()
                .fetch();
        return result;
    }
}
