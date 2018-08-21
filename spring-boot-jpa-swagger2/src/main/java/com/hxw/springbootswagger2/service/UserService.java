package com.hxw.springbootswagger2.service;

import com.hxw.springbootswagger2.entity.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User getUser(Integer id);

    boolean saveUser(User user);

    boolean updateUser(User user);

    boolean deleteUser(Integer id);
}
