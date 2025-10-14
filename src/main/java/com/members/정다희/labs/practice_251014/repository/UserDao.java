package com.members.정다희.labs.practice_251014.repository;

import com.members.정다희.labs.practice_251014.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    public User getUser(String name);
    public List<User> getUsers();
    public void addUser(User user);
    public Optional<User> getOptionalUser(String name);
}
