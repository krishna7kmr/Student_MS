package com.nt.controller;

import com.nt.service.OrderDetail;
import com.nt.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<?> createOrder(){

        OrderDetail order = this.orderService.createOrder();
        //send notification to notification service
        orderCreatedNotification(order);
        return ResponseEntity.ok("order created");
    }

    @Autowired
    private StreamBridge streamBridge;

    private void orderCreatedNotification(OrderDetail orderDetail) {
         // "orderCreatedEvent-out-0", orderDetail)
        // logic to send notification to notification service
        boolean send = streamBridge.send("orderCreatedEvent-out-0", orderDetail);
       if(send){
           System.out.println("Event is successfully send to notification service");
       }
       else{
           System.out.println("Event isd failed");
       }

    }
}
