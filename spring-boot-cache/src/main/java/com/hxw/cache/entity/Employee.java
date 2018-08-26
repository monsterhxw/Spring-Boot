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
//@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 20)
    private String name;

    @Column(length = 20)
    private String email;

    @Column(length = 1)
    private Integer sex; //性别 0女 1男

    @ManyToOne
    @JoinColumn(name = "deptId")
    private Department department;

    public Employee() {
        super();
    }

    public Employee(Integer id, String name, String email, Integer sex, Department department) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.sex = sex;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", sex=" + sex + ", deptId="
                + department + "]";
    }

}