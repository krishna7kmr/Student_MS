package com.nt.Notification_Service.function;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.nt.Notification_Service.dto.OrderInformation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;
import java.util.function.Supplier;

@Configuration
public class NotificationService {


    @Bean
    public Supplier<String> testing(){
        return ()-> "This is testing";
    }

    @Bean
    public Function<String,String> sayHello(){
        return (arg)-> "This is testing: "+ arg;
    }

    @Bean
    public Function<OrderInformation , String> orderNotification(){

        return (orderInformation)->{
            System.out.println(orderInformation.getOrderId());
            System.out.println(orderInformation.getPrice());
            System.out.println(orderInformation.getPhoneNo());
            System.out.println(orderInformation.getEmail());

            return orderInformation.getOrderId();
        };
    }
}
