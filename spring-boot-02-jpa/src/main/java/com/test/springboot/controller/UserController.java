package com.test.springboot.controller;

import com.test.springboot.entity.User;
import com.test.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询所有用户
     *
     * @param model
     * @return
     */
    @GetMapping("/users")
    public String userList(Model model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "user/list";
    }

    /**
     * 查询用户
     *
     * @return
     */
    @GetMapping(value = "/user")
    public String toAddUserPage() {
        return "user/userAdd";
    }

    /**
     * 增加用户
     *
     * @param user
     * @return
     */
    @PostMapping(value = "/user")
    public String addUser(User user) {
        System.out.println(user);
        userService.saveUser(user);
        return "redirect:/users";
    }

    /**
     * 跳转到编辑用户页面
     *
     * @param model
     * @param id
     * @return
     */
    @GetMapping(value = "/user/{id}")
    public String toEditUserPage(Model model, @PathVariable("id") Integer id) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "user/userAdd";
    }

    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    @PutMapping(value = "/user")
    public String editUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/user/{id}")
    public String deleteUser(@PathVariable(value = "id") Integer id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

}
