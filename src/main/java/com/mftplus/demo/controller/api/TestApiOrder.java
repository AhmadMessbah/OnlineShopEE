package com.mftplus.demo.controller.api;

import com.mftplus.demo.model.entity.Order;
import com.mftplus.demo.model.entity.OrderItem;
import com.mftplus.demo.model.entity.enums.OrderStatus;
import com.mftplus.demo.model.service.OrderService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.List;

@Path("/testOrder")
public class TestApiOrder {
    @Inject
    private OrderService orderService;

    @GET
    public String testOrder() {
        OrderItem orderItem = OrderItem.builder().unitPrice(300L).totalPrice(500).quantity(3).build();
        Order order = Order.builder().orderItems(List.of(orderItem)).orderStatus(OrderStatus.PENDING).discount(200).build();
        orderService.save(order);
        return order.toString();
    }

}
