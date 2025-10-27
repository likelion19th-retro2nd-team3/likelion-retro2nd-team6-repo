package com.example.demo.config;


import com.example.demo.model.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarConfig {

    @Bean
    public Car car() {
        return new Car("Tesla", 90000);
    }
}