package com.hxw.grpcclient.controller;

import com.hxw.grpcclient.GrpcClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrpcClientController {

    @Autowired
    private GrpcClientService grpcClientService;

    @GetMapping("/{name}")
    public String printMessage(@PathVariable(value = "name") String name) {
        return grpcClientService.sendMessage(name);
    }

}
