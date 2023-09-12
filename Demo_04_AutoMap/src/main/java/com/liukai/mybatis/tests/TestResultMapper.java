package com.liukai.mybatis.tests;

import com.liukai.mybatis.mappers.DeptMapper;
import com.liukai.mybatis.mappers.DynamisSqlMapper;
import com.liukai.mybatis.mappers.EmpMapper;
import com.liukai.mybatis.pojo.Dept;
import com.liukai.mybatis.pojo.Emp;
import com.liukai.mybatis.pojo.User;
import com.liukai.mybatis.util.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author liukai
 * @version 1.0
 * @date 2023/9/10 13:08
 */
public class TestResultMapper {

    @Test
    public void getAllEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //通过代理模式创建UserMapper接口的代理实现类对象
        EmpMapper userMapper = sqlSession.getMapper(EmpMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的SQL语句
        List<Emp> allEmp = userMapper.getAllEmp();

        allEmp.forEach(emp-> System.out.println("emp = " + emp));
    }

    @Test
    public void getEmpAndDeptByEid(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //通过代理模式创建UserMapper接口的代理实现类对象
        EmpMapper userMapper = sqlSession.getMapper(EmpMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的SQL语句
        Emp allEmp = userMapper.getEmpAndDeptByEid(1);

        System.out.println("emp = " + allEmp);
    }

    @Test
    public void getEmpAndDeptByTwoStep(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper userMapper = sqlSession.getMapper(EmpMapper.class);
        Emp allEmp = userMapper.getEmpByStepOne(1);
        /**
         * 执行了两个sql
         * select * from t_emp where eid = ?
         * select * from t_dept where did = ?
         */
        //System.out.println("emp = " + allEmp);
        /**
         * 测试延迟加载
         * 只执行一个sql: <setting name="lazyLoadingEnabled" value="true"/> 必须打开
         * select * from t_emp where eid = ?
         */
        System.out.println("emp = " + allEmp.getEmpName());
        System.out.println("===============================");
        /**
         * 只执行一个sql
         * select * from t_dept where did = ?
         */
        System.out.println("emp = " + allEmp.getDept());
    }


    /**
     * 处理一对多的关系
     * 1、collection
     */
    @Test
    public void getDeptAndEmps(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //通过代理模式创建UserMapper接口的代理实现类对象
        DeptMapper userMapper = sqlSession.getMapper(DeptMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的SQL语句
        Dept allEmp = userMapper.getDeptAndEmps(1);

        System.out.println("emp = " + allEmp);
    }

    /**
     * 处理一对多的关系
     * 2、分布查询
     */
    @Test
    public void getDeptAndEmpsByTwoStep(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //通过代理模式创建UserMapper接口的代理实现类对象
        DeptMapper userMapper = sqlSession.getMapper(DeptMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的SQL语句
        Dept allEmp = userMapper.getDeptAndEmpByStepOne(1);

        System.out.println("emp = " + allEmp);
    }



}
