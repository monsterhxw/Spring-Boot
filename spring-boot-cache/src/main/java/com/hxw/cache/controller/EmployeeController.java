package com.hxw.cache.controller;

import com.hxw.cache.entity.Employee;
import com.hxw.cache.service.EmployeeService;
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
@RequestMapping(value = "/emp/*")
@Api("EmployeeAPI")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @ApiOperation("get Employee List")
    @GetMapping(value = "/emps")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    /**
     * 测试@Cacheable
     *
     * @param id
     * @return
     */
    @ApiOperation("get Employee by Id")
    @ApiImplicitParam(name = "id", value = "单个员工信息", paramType = "path", required = true, dataType = "Integer")
    @GetMapping(value = "/emp/{id}")
    public Employee getEmployee(@PathVariable(value = "id") Integer id) {
        return employeeService.getEmployee(id);
    }

    /**
     * 测试@CachePut
     *
     * @param employee
     * @return
     */
    @ApiOperation("edit Employee")
    @ApiImplicitParam(name = "employee", value = "单个员工信息", dataType = "Employee")
    @GetMapping(value = "/emp")
    public Employee editEmployee(Employee employee) {
        return employeeService.editEmployee(employee);
    }

    /**
     * 测试@CacheEvict
     *
     * @param id
     * @return
     */
    @ApiOperation("delete Employee by Id")
    @ApiImplicitParam(name = "id", value = "单个员工信息", paramType = "path", required = true, dataType = "Integer")
    @GetMapping(value = "/delemp/{id}")
    public String deleteEmployee(@PathVariable(value = "id") Integer id) {
        employeeService.deleteEmployee(id);
        return "@CacheEvict";
    }

    /**
     * 测试@Caching
     *
     * @param name
     * @return
     */
    @GetMapping(value = "/empname/{name}")
    public List<Employee> getEmployeesByName(@PathVariable(value = "name") String name) {
        return employeeService.getEmployeesByName(name);
    }

}
