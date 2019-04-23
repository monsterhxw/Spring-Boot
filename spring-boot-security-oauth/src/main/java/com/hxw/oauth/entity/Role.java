package com.hxw.oauth.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Role implements Serializable {

    private static final long serialVersionUID = 7978311029297110025L;

    /**
     * 主键
     */
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 角色名称
     */
    @Getter
    @Setter(AccessLevel.PACKAGE)
    private String name;

    /**
     * 角色描述
     */
    @Getter
    @Setter(AccessLevel.PACKAGE)
    private String description;

}
