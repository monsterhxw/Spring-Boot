package com.hxw.oauth.service;

import com.hxw.oauth.entity.User;

public interface UserService {

    User findByName(String name);
}
