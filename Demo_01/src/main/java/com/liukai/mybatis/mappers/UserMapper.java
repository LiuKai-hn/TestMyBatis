package com.liukai.mybatis.mappers;

import com.liukai.mybatis.pojo.User;

import java.util.List;

/**
 * @Author：liukai
 * @Date：2023/9/8 10:52
 */
public interface UserMapper {



    /**
     *  添加用户
     * mybatis 面向接口编程的两个一致：
     *  1、映射文件的namespace要和mapper的全类名保持一致
     *  2、sql id 名要和 接口中的方法名保持一致
     * @return
     */
    int insertUser();

    // 修改用户信息
    int updateUser();

    // 删除用户信息
    int deleteUser();


    // 查询单个用户
    User getUserById();

    // 查询全部用户
    List<User> getUserList();




}
