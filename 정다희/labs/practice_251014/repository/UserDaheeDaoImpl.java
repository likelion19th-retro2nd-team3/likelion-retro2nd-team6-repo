package com.members.정다희.labs.practice_251014.repository;

import com.members.정다희.labs.practice_251014.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("userDao")
public class UserDaheeDaoImpl implements UserDao{
    @Override
    public User getUser(String name) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return List.of();
    }

    @Override
    public void addUser(User user) {
        System.out.println(user + "의 정보가 dahee dao로 저장되었습니다.");
    }

    @Override
    public Optional<User> getOptionalUser(String name) {
        return Optional.empty();
    }
}
