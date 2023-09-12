package com.liukai.mybatis.tests;

import com.liukai.mybatis.mappers.DynamisSqlMapper;
import com.liukai.mybatis.pojo.Emp;
import com.liukai.mybatis.util.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：liukai
 * @Date：2023/9/12 9:32
 */
public class TestDynamisSqlMapper {

    /**
     * 动态Sql
     */
    @Test
    public void getEmpByCondition(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //通过代理模式创建UserMapper接口的代理实现类对象
        DynamisSqlMapper userMapper = sqlSession.getMapper(DynamisSqlMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的SQL语句
        List<Emp> emps = userMapper.getEmpByCondition(new Emp(null, "zs", 25, null, null, null));

        emps.forEach(emp-> System.out.println("emp = " + emp));
    }


    @Test
    public void getEmpListByWhere(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //通过代理模式创建UserMapper接口的代理实现类对象
        DynamisSqlMapper userMapper = sqlSession.getMapper(DynamisSqlMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的SQL语句
        List<Emp> emps = userMapper.getEmpListByWhere(new Emp(null, "zs", 25, null, null, null));

        emps.forEach(emp-> System.out.println("emp = " + emp));
    }


    @Test
    public void getEmpListByTrim(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //通过代理模式创建UserMapper接口的代理实现类对象
        DynamisSqlMapper userMapper = sqlSession.getMapper(DynamisSqlMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的SQL语句
        List<Emp> emps = userMapper.getEmpListByTrim(new Emp(null, "", 25, null, null, null));

        emps.forEach(emp-> System.out.println("emp = " + emp));
    }

    @Test
    public void getEmpListByChoose(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //通过代理模式创建UserMapper接口的代理实现类对象
        DynamisSqlMapper userMapper = sqlSession.getMapper(DynamisSqlMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的SQL语句
        List<Emp> emps = userMapper.getEmpListByChoose(new Emp(null, "", 25, null, null, null));

        emps.forEach(emp-> System.out.println("emp = " + emp));
    }


    @Test
    public void insertMoreEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //通过代理模式创建UserMapper接口的代理实现类对象
        DynamisSqlMapper userMapper = sqlSession.getMapper(DynamisSqlMapper.class);
        List<Emp> insertEmps = new ArrayList<>();
        insertEmps.add(new Emp(null, "lk", 28, "男", "11@qq.com", null));
        insertEmps.add(new Emp(null, "zyx", 26, "女", "11@qq.com", null));
        insertEmps.add(new Emp(null, "aaa", 26, "女", "11@qq.com", null));
        int cnt = userMapper.insertMoreEmp(insertEmps);

        System.out.println("cnt = " + cnt);
    }


    @Test
    public void deleteMoreByArrayV1(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //通过代理模式创建UserMapper接口的代理实现类对象
        DynamisSqlMapper userMapper = sqlSession.getMapper(DynamisSqlMapper.class);
        int cnt = userMapper.deleteMoreByArrayV1(new int[]{5,7});

        System.out.println("cnt = " + cnt);
    }
    @Test
    public void deleteMoreByArrayV2(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //通过代理模式创建UserMapper接口的代理实现类对象
        DynamisSqlMapper userMapper = sqlSession.getMapper(DynamisSqlMapper.class);
        int cnt = userMapper.deleteMoreByArrayV2(new int[]{5,7});

        System.out.println("cnt = " + cnt);
    }

}
