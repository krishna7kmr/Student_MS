package com.nt.function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class NotifyService {

    @Bean
    public Consumer<String> consumerAck(){

        return (str)->{
            System.out.println("Inside order service ACK");
            System.out.println("**********************************");
            System.out.println("data updated: "+str);

        };
    }
}
