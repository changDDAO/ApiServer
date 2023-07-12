package com.changddao.ApiServer.controller;

import com.changddao.ApiServer.entity.Order;
import com.changddao.ApiServer.entity.OrderItem;
import com.changddao.ApiServer.service.OrderService;
import com.changddao.ApiServer.service.order_query.OrderFetchedDto;
import com.changddao.ApiServer.service.order_query.OrderQueryService;
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
    private final OrderQueryService orderQueryService;
   @GetMapping("/api/v2/orders")
    public Result ordersV2() {
       List<Order> orders = orderService.ordersWithMember();
       List<OrderFetchedDto> collect = orders.stream().map(order -> new OrderFetchedDto(order))
               .collect(Collectors.toList());
       return new Result(collect);
   }
// dto 반환 시 Wrapper class로 감싸서 반환하자 List로 반환 시 효율성 떨어짐,  한뷰에는 여러 dto가 보내질 수 있기에
    //감싸서 해결하자
    @GetMapping("/api/v3/orders")
    public List<OrderFetchedDto> ordersV3() {
        List<Order> orders = orderService.ordersWithItem();
        List<OrderFetchedDto> collect = orders.stream().map(order -> new OrderFetchedDto(order))
                .collect(Collectors.toList());
        return collect;
    }

    @GetMapping("/api/v4/orders")
    public Result ordersV4(){
       return new Result(orderQueryService.OrderV4());
    }

}
