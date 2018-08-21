package com.hxw.springbootswagger2.repository;

import com.hxw.springbootswagger2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
