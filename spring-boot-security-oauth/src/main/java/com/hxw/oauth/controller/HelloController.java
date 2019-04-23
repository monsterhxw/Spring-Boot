package com.hxw.oauth.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @GetMapping
    public String getHelloMessage() {
        return "Hello Spring Security";
    }

    @GetMapping(value = "/helloAdmin")
    @PreAuthorize("hasAnyRole('admin')")
    public String getHelloAdmin() {
        return "Hello admin Security";
    }

    @GetMapping(value = "/helloUser")
    @PreAuthorize("hasAnyRole('admin','user')")
    public String getHelloUser() {
        return "Hello user";
    }

}
