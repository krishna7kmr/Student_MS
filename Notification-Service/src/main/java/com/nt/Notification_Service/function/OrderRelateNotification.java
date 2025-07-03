package com.nt.Notification_Service.function;

import com.nt.Notification_Service.dto.OrderDetail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLOutput;
import java.util.function.Function;

@Configuration
public class OrderRelateNotification {

    @Bean
    public Function<OrderDetail,String> orderEventReceiver(){
        return (orderDetail -> {
            System.out.println("Sending notification ");
            logicToSendEmailAndMessageToUser(orderDetail.getEmail(),orderDetail.getUserPhone());
            return "order notification send to user";
        });
    }

    private void logicToSendEmailAndMessageToUser(String email, String userPhone) {
        System.out.println("sending email to : "+email);
        System.out.println("sending sms to : "+userPhone);
        System.out.println("notification send to user ");
        System.out.println("______________________________________________________");
    }
}
