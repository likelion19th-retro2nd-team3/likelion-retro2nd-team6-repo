package com.example.demo.repository;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    public int countUsers() {
        return 3;
    }
}