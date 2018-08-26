package com.hxw.cache.service.impl;

import com.hxw.cache.entity.Department;
import com.hxw.cache.repository.DepartmentRepository;
import com.hxw.cache.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartment(Integer id) {
        return departmentRepository.findById(id).get();
    }

    @Override
    public void saveDepartment(Department department) {
        try {
            departmentRepository.save(department);
        } catch (Exception e) {
            log.info("增加部门失败！错误信息：" + e.getMessage());
        }
    }

    @Override
    public void editDepartment(Department department) {
        try {
            departmentRepository.save(department);
        } catch (Exception e) {
            log.info("修改部门失败！错误信息：" + e.getMessage());
        }
    }

    @Override
    public void deleteDepartment(Integer id) {
        try {
            departmentRepository.deleteById(id);
        } catch (Exception e) {
            log.info("删除部门失败！错误信息：" + e.getMessage());
        }
    }

}
