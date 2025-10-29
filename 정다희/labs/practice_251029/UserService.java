package org.example.restexam.service;

import org.example.restexam.domain.User;
import java.util.List;

public interface UserService {
    List<User> getUsers();
    User getUser(Long id);
    User addUser(User user);
    User updateUser(User user);
    void deleteUser(Long id);
}
