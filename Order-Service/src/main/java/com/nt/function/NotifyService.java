package com.nt.function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class NotifyService {

    @Bean
    public Consumer<String> consumerAck(){

        return System.out::println;
    }
}
