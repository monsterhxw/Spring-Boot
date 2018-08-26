package com.hxw.cache.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 使用JPA注解配置映射关系
 *
 * @Entity注解 是用来告知JPA这是一个实体类（和数据库映射的类）
 * @Data 使用Lombok来生成getter和setter方法
 * @Table注解 是指定和那个数据表对应；如果省略默认表名就是user
 */
@Entity
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 20)
    private String deptName;

   /* @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Employee> employees;*/

    public Department() {
        super();
    }

    public Department(Integer id, String deptName) {
        super();
        this.id = id;
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        String result = String.format(
                "Department [ id = %d, deptName = '%s' ] %n",
                id, deptName);
       /* if (employees != null) {
            for (Employee employee : employees) {
                result += String.format(
                        "Employee [id=%d, name='%s']%n",
                        employee.getId(), employee.getName());
            }
        }*/

        return result;
    }
}
