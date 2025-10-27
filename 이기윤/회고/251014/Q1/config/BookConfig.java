package com.example.demo.config;

import com.example.demo.model.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BookConfig {

    @Bean
    public Book bookA() {
        return new Book("Spring in Action");
    }

    @Bean
    @Scope("prototype")
    public Book bookB() {
        return new Book("Effective Java");
    }
}