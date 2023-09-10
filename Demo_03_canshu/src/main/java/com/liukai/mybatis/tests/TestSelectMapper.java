package com.liukai.mybatis.tests;

import com.liukai.mybatis.mappers.ParamterMapper;
import com.liukai.mybatis.mappers.SelectMapper;
import com.liukai.mybatis.pojo.User;
import com.liukai.mybatis.util.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

/**
 * @author liukai
 * @version 1.0
 * @date 2023/9/10 10:50
 */
public class TestSelectMapper {


    @Test
    public void getUserById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //通过代理模式创建UserMapper接口的代理实现类对象
        SelectMapper userMapper = sqlSession.getMapper(SelectMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的SQL语句
        User user = userMapper.getUserById(2);
        System.out.println("user = " + user);
    }

    @Test
    public void getUserList(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //通过代理模式创建UserMapper接口的代理实现类对象
        SelectMapper userMapper = sqlSession.getMapper(SelectMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的SQL语句
        List<User> users = userMapper.getUserList();
        users.forEach(user-> System.out.println("user = " + user));
    }

    @Test
    public void getCount(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //通过代理模式创建UserMapper接口的代理实现类对象
        SelectMapper userMapper = sqlSession.getMapper(SelectMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的SQL语句
        Integer cnt = userMapper.getCount();
        System.out.println("cnt = " + cnt);
    }

    @Test
    public void getUserToMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //通过代理模式创建UserMapper接口的代理实现类对象
        SelectMapper userMapper = sqlSession.getMapper(SelectMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的SQL语句
        Map<String, Object> userToMap = userMapper.getUserToMap(2);
        System.out.println("userToMap = " + userToMap);
    }

    @Test
    public void getAllUserToMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //通过代理模式创建UserMapper接口的代理实现类对象
        SelectMapper userMapper = sqlSession.getMapper(SelectMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的SQL语句
        List<Map<String, Object>> allUserToMap = userMapper.getAllUserToMap();
        for (Map<String, Object> stringObjectMap : allUserToMap) {
            System.out.println("stringObjectMap = " + stringObjectMap);
        }

    }

    @Test
    public void getAllUserToMapV2(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //通过代理模式创建UserMapper接口的代理实现类对象
        SelectMapper userMapper = sqlSession.getMapper(SelectMapper.class);

        Map<String, Object> allUserToMapV2 = userMapper.getAllUserToMapV2();

        System.out.println(allUserToMapV2);

    }

    @Test
    public void getMohu(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //通过代理模式创建UserMapper接口的代理实现类对象
        SelectMapper userMapper = sqlSession.getMapper(SelectMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的SQL语句
        List<User> users = userMapper.testMohu("张三");
        users.forEach(user-> System.out.println("user = " + user));
    }

    @Test
    public void deleteMore(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //通过代理模式创建UserMapper接口的代理实现类对象
        SelectMapper userMapper = sqlSession.getMapper(SelectMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的SQL语句
        int cnt = userMapper.deleteMore("2,3");
        System.out.println(cnt);
    }

    @Test
    public void getAllUserByTableName(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //通过代理模式创建UserMapper接口的代理实现类对象
        SelectMapper userMapper = sqlSession.getMapper(SelectMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的SQL语句
        List<User> users = userMapper.getAllUser("t_user");
        users.forEach(user-> System.out.println("user = " + user));
    }

    @Test
    public void insertUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //通过代理模式创建UserMapper接口的代理实现类对象
        SelectMapper userMapper = sqlSession.getMapper(SelectMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的SQL语句
        int cnt = userMapper.insertUser(new User(null,"ls","222222",28,"女","123@qq.com"));
        System.out.println("cnt = " + cnt);
    }




}
