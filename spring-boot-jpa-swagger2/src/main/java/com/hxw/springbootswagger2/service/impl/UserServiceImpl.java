package com.hxw.springbootswagger2.service.impl;

import com.hxw.springbootswagger2.entity.User;
import com.hxw.springbootswagger2.repository.UserRepository;
import com.hxw.springbootswagger2.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public boolean saveUser(User user) {
        boolean flag = false;
        try {
            userRepository.save(user);
            flag = true;
        } catch (Exception e) {
            log.info("增加用户失败");
        }
        return flag;
    }

    @Override
    public boolean updateUser(User user) {
        boolean flag = false;
        try {
            userRepository.save(user);
            flag = true;
        } catch (Exception e) {
            log.info("修改用户失败");
        }
        return flag;
    }

    @Override
    public boolean deleteUser(Integer id) {
        boolean flag = false;
        try {
            userRepository.deleteById(id);
            flag = true;
        } catch (Exception e) {
            log.info("删除用户失败");
        }
        return flag;
    }
}
