package com.test.springboot.service;

import com.test.springboot.entity.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User getUser(Integer id);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Integer id);
}
