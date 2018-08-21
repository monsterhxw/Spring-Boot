package com.hxw.springbootswagger2.controller;

import com.hxw.springbootswagger2.entity.User;
import com.hxw.springbootswagger2.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("用户信息管理")
@RequestMapping("/user/*")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询所有用户
     *
     * @return
     */
    @ApiOperation("获取用户列表")
    @GetMapping("/users")
    public List<User> userList() {
        List<User> users = userService.getUsers();
        return users;
    }

    /**
     * 增加用户
     *
     * @param user
     * @return
     */
    @ApiOperation("新增用户")
    @PostMapping(value = "/user")
    public boolean addUser(User user) {
        return userService.saveUser(user);
    }

    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    @ApiOperation("修改用户")
    @ApiImplicitParam(name = "user", value = "单个用户信息", dataType = "User")
    @PutMapping(value = "/user")
    public boolean editUser(User user) {
        return userService.saveUser(user);
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @ApiOperation("删除用户")
    @ApiImplicitParam(name = "id", value = "单个用户信息", paramType = "path", required = true, dataType = "Integer")
    @DeleteMapping(value = "/user/{id}")
    public boolean deleteUser(@PathVariable(value = "id") Integer id) {
        return userService.deleteUser(id);
    }

}
