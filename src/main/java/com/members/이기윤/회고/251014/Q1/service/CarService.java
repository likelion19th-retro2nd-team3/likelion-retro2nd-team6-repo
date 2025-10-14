package com.example.demo.service;

import com.example.demo.model.Car;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private final Car car;

    public CarService(Car car) {
        this.car = car;
    }

    public void printCarInfo() {
        System.out.println("자동차 브랜드: " + car.getBrand());
        System.out.println("가격: " + car.getPrice());
    }
}