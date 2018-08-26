package com.hxw.cache.controller;

import com.hxw.cache.entity.Department;
import com.hxw.cache.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/dept/*")
@Api(value = "Department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @ApiOperation("get Department List")
    @GetMapping(value = "/dept")
    public List<Department> getEmployees() {
        return departmentService.getDepartments();
    }

    @ApiOperation("get Department by Id")
    @ApiImplicitParam(name = "id", value = "单个部门信息", paramType = "path", required = true, dataType = "Integer")
    @GetMapping(value = "/dept/{id}")
    public Department getEmployee(@PathVariable(value = "id") Integer id) {
        return departmentService.getDepartment(id);
    }
}
