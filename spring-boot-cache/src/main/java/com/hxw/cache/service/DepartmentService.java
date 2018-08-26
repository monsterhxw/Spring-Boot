package com.hxw.cache.service;

import com.hxw.cache.entity.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> getDepartments();

    Department getDepartment(Integer id);

    void saveDepartment(Department department);

    void editDepartment(Department department);

    void deleteDepartment(Integer id);

}
