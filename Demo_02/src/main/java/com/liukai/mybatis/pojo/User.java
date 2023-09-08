package com.liukai.mybatis.pojo;

import lombok.*;

/**
 * @Author：liukai
 * @Date：2023/9/8 10:48
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private String sex;
    private String email;
}
