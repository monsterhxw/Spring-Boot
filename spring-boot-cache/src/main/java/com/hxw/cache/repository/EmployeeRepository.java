package com.hxw.cache.repository;

import com.hxw.cache.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    /**
     * 通过名字模糊查询员工
     *
     * @param name
     * @return
     */
    @Query(value = "select e from Employee e where e.name like %:name%")
    List<Employee> findByNameLike(@Param(value = "name") String name);
}
