package com.hxw.cache.service;

import com.hxw.cache.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployees();

    Employee getEmployee(Integer id);

    void savaEmployee(Employee employee);

    Employee editEmployee(Employee employee);

    void deleteEmployee(Integer id);

    List<Employee> getEmployeesByName(String name);

}
