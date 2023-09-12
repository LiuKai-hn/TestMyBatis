package com.liukai.mybatis.pojo;

import lombok.*;

import java.io.Serializable;

/**
 * @author liukai
 * @version 1.0
 * @date 2023/9/10 13:01
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Emp implements Serializable {

    private Integer eid;
    private String empName;
    private Integer age;
    private String sex;
    private String email;
    private Dept dept;
}
