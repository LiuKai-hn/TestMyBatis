package com.liukai.mybatis.tests;

import com.liukai.mybatis.mappers.ParamterMapper;
import com.liukai.mybatis.mappers.UserMapper;
import com.liukai.mybatis.pojo.User;
import com.liukai.mybatis.util.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * @Author：liukai
 * @Date：2023/9/8 11:03
 */
public class MybatisTest {

    @Test
    public void TestInsertUser() throws IOException {
        //读取MyBatis的核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //通过核心配置文件所对应的字节输入流创建工厂类SqlSessionFactory，生产SqlSession对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //创建SqlSession对象，此时通过SqlSession对象所操作的sql都必须手动提交或回滚事务
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建SqlSession对象，此时通过SqlSession对象所操作的sql都会自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的SQL语句
        int result = userMapper.insertUser();
        //sqlSession.commit();
        System.out.println("结果：" + result);
    }

    @Test
    public void TestUpdateUser() throws IOException {
        //读取MyBatis的核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //通过核心配置文件所对应的字节输入流创建工厂类SqlSessionFactory，生产SqlSession对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //创建SqlSession对象，此时通过SqlSession对象所操作的sql都必须手动提交或回滚事务
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建SqlSession对象，此时通过SqlSession对象所操作的sql都会自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的SQL语句
        int result = userMapper.updateUser();
        //sqlSession.commit();
        System.out.println("结果：" + result);
    }

    @Test
    public void TestDeleteUser() throws IOException {
        //读取MyBatis的核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //通过核心配置文件所对应的字节输入流创建工厂类SqlSessionFactory，生产SqlSession对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //创建SqlSession对象，此时通过SqlSession对象所操作的sql都必须手动提交或回滚事务
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建SqlSession对象，此时通过SqlSession对象所操作的sql都会自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的SQL语句
        int result = userMapper.deleteUser();
        //sqlSession.commit();
        System.out.println("结果：" + result);
    }

    @Test
    public void TestGetUserById() throws IOException {
        //读取MyBatis的核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //通过核心配置文件所对应的字节输入流创建工厂类SqlSessionFactory，生产SqlSession对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //创建SqlSession对象，此时通过SqlSession对象所操作的sql都必须手动提交或回滚事务
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建SqlSession对象，此时通过SqlSession对象所操作的sql都会自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的SQL语句
        User result = userMapper.getUserById();
        //sqlSession.commit();
        System.out.println("结果：" + result);
    }


    @Test
    public void TestGetUserList() throws IOException {

        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //通过代理模式创建UserMapper接口的代理实现类对象
        ParamterMapper userMapper = sqlSession.getMapper(ParamterMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的SQL语句
        List<User> list = userMapper.getAllUser();
        list.forEach(user -> System.out.println(user));

    }

    @Test
    public void TestGetUserByUserName() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //通过代理模式创建UserMapper接口的代理实现类对象
        ParamterMapper userMapper = sqlSession.getMapper(ParamterMapper.class);
        User result = userMapper.getUserByUserName("lk");
        System.out.println("结果：" + result);
    }

    /**
     * 测试多个参数
     * @throws IOException
     */
    @Test
    public void TestLogin() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //通过代理模式创建UserMapper接口的代理实现类对象
        ParamterMapper userMapper = sqlSession.getMapper(ParamterMapper.class);
        User result = userMapper.checkLogin("lk","123");
        System.out.println("结果：" + result);
    }


    /**
     * 测试多个参数
     * 测试通过@Param映射参数来填充
     * select * from t_user where username=#{username} and password=#{password}
     * @throws IOException
     */
    @Test
    public void TestLoginV2() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //通过代理模式创建UserMapper接口的代理实现类对象
        ParamterMapper userMapper = sqlSession.getMapper(ParamterMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("username","lk");
        map.put("password","123");
        User result = userMapper.checkLoginV2(map);
        System.out.println("结果：" + result);
    }

    /**
     * 测试多个参数
     * select * from t_user where username=#{username} and password=#{password}
     * @throws IOException
     */
    @Test
    public void TestLoginV3() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //通过代理模式创建UserMapper接口的代理实现类对象
        ParamterMapper userMapper = sqlSession.getMapper(ParamterMapper.class);
        User result = userMapper.checkLoginV3("lk","123");
        System.out.println("结果：" + result);
    }

    /**
     * 添加用户
     * select * from t_user where username=#{username} and password=#{password}
     * @throws IOException
     */
    @Test
    public void insertUser() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //通过代理模式创建UserMapper接口的代理实现类对象
        ParamterMapper userMapper = sqlSession.getMapper(ParamterMapper.class);
        int result = userMapper.insertUser(new User(null,"zs","123456",28,"男","123@qq.com"));
        System.out.println("结果：" + result);
    }

}
