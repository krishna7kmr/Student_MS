package com.nt.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {

    public OrderDetail createOrder(){

        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setOrderId(UUID.randomUUID().toString());
        orderDetail.setEmail("k@gmail.com");
        orderDetail.setOrderPaymentStatus(true);
        orderDetail.setUserId("kri123");
        orderDetail.setUserPhone("887799");
        orderDetail.setBookId(UUID.randomUUID().toString());
        return orderDetail;

    }
}
