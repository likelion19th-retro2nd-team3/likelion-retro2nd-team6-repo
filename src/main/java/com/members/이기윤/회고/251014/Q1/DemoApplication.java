package com.example.demo;

import com.example.demo.model.Book;
import com.example.demo.service.CarService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private final CarService carService;
    private final ApplicationContext context;

    public DemoApplication(CarService carService, ApplicationContext context) {
        this.carService = carService;
        this.context = context;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) {

        carService.printCarInfo();


        Book bookA1 = context.getBean("bookA", Book.class);
        Book bookA2 = context.getBean("bookA", Book.class);
        Book bookB1 = context.getBean("bookB", Book.class);
        Book bookB2 = context.getBean("bookB", Book.class);

        System.out.println("bookA1 == bookA2 ? " + (bookA1 == bookA2));
        System.out.println("bookB1 == bookB2 ? " + (bookB1 == bookB2));
    }
}