package com.hxw.oauth.security;

import com.hxw.oauth.entity.Role;
import com.hxw.oauth.entity.User;
import com.hxw.oauth.service.UserService;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@Primary
@Slf4j
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("UserDetailServiceImpl.loadUserByUsername() start");

        // 通过 name 获取用户信息
        User user = userService.findByName(username);

        if (null == user) {
            throw new UsernameNotFoundException("User not found");
        }

        // 定义权限列表
        List<GrantedAuthority> authorities = new ArrayList<>();

        // 用户可以访问的资源名称（或者说用户所拥有的权限） 注意：必须"ROLE_"开头
//        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()));

        for (Role role : user.getRole()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        }

        org.springframework.security.core.userdetails.User userDetails = new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), authorities);
        return userDetails;
    }
}
