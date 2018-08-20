package com.test.springboot.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 使用JPA注解配置映射关系
 *
 * @Entity注解 是用来告知JPA这是一个实体类（和数据库映射的类）
 * @Table注解 是指定和那个数据表对应；如果省略默认表名就是user
 */
@Entity
@Table(name = "tb1_user")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "lastName", length = 50)
    private String lastName;

    @Column
    private String email;

}
