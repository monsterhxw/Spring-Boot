package com.hxw.cache.service.impl;

import com.hxw.cache.entity.Employee;
import com.hxw.cache.repository.EmployeeRepository;
import com.hxw.cache.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
/**
 * 抽取缓存公共属性
 */
@CacheConfig(cacheNames = {"emp"})
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployees() {
        log.info("查询所有员工");
        return employeeRepository.findAll();
    }

    @Override
    @Cacheable(/*cacheNames = {"emp"},*/ key = "#id",/* keyGenerator = "myKeyGenerator",*/
            condition = "#id > 1 and #root.methodName eq 'getEmployee' ", unless = "#id == 2")
    /**
     * @Cacheable
     * 把返回结果存入缓存中
     */
    public Employee getEmployee(Integer id) {
        log.info("查询ID" + id + "的员工");
        return employeeRepository.findById(id).get();
    }

    @Override
    public void savaEmployee(Employee employee) {
        try {
            employeeRepository.save(employee);
        } catch (Exception e) {
            log.info("增加员工失败！错误信息：" + e.getMessage());
        }
    }

    @Override
    @CachePut(/*cacheNames = {"emp"},*/ key = "#result.id")
    /**
     * @CachePut(cacheNames = {"emp"}, key = "#result.id")
     *  即调用方法，同时也更新缓存
     */
    public Employee editEmployee(Employee employee) {
        try {
            employeeRepository.save(employee);
            log.info(employee.toString());
        } catch (Exception e) {
            log.info("修改员工失败！错误信息：" + e.getMessage());
        } finally {
            return employee;
        }
    }

    @Override
    @CacheEvict(/*cacheNames = {"emp"},*/ key = "#id")
    /**
     *@CacheEvict
     *清除缓存
     * 属性 1、allEntries = true 清除指定缓存的所有数据
     *     2、beforeInvocation = true 缓存的清除是在方法执行之前执行，false是默认代表是在方法执行之后执行
     */
    public void deleteEmployee(Integer id) {
        try {
            //employeeRepository.deleteById(id);
        } catch (Exception e) {
            log.info("删除用户失败！错误信息：" + e.getMessage());
        }
    }

    @Override
    @Caching(
            cacheable = {
                    @Cacheable(/*cacheNames = {"emp"},*/ key = "#name")
            },
            put = {
                    @CachePut(/*cacheNames = {"emp"},*/ key = "#name"),
            }
    )
    /**
     * @Caching 是一个组合的注解，包含 @Cacheable、 @CahchePut 和 @CacheEvict
     * 定义复杂的缓存规则
     */
    public List<Employee> getEmployeesByName(String name) {
        return employeeRepository.findByNameLike(name);
    }
}
