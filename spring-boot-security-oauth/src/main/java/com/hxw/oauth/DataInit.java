package com.hxw.oauth;

import com.hxw.oauth.entity.Role;
import com.hxw.oauth.entity.User;
import com.hxw.oauth.repository.RoleRepository;
import com.hxw.oauth.repository.UserRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DataInit {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void dataInt() {
        List<Role> roles = new ArrayList<>();
        Role adminRole = Role.builder()
            .name("admin")
            .description("管理员")
            .build();
        Role userRole = Role.builder()
            .name("user")
            .description("普通用户")
            .build();

        roleRepository.save(adminRole);
        roleRepository.save(userRole);

        roles.add(adminRole);
        roles.add(userRole);

        User admin = User.builder()
            .id(1L)
            .name("admin")
            .password(passwordEncoder.encode("admin"))
            .role(roles)
            .build();

        User user = User.builder()
            .id(2L)
            .name("user")
            .password(passwordEncoder.encode("user"))
            .role(Arrays.asList(userRole))
            .build();

        userRepository.save(admin);
        userRepository.save(user);
    }
}
