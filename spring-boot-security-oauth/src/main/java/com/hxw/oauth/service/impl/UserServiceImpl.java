package com.hxw.oauth.service.impl;

import com.hxw.oauth.entity.User;
import com.hxw.oauth.repository.UserRepository;
import com.hxw.oauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }

}
