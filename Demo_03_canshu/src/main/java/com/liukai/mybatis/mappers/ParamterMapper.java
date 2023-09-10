package com.liukai.mybatis.mappers;

import com.liukai.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author liukai
 * @version 1.0
 * @date 2023/9/9 18:57
 */
public interface ParamterMapper {

    /**
     * mytbatis 获取参数值的两种方式：${} 和 #{}
     * ${}本质字符串拼接，单引号得自己拼接
     *      eg: select * from t_user where username='${username}'
     * #{}本质占位符拼接，根据参数顺序来的，并不是根据参数名称
     *      eg:select * from t_user where username=#{aaa}
     * Mybatis 获取接口
     */

    /**
     * 如果参数为多个,Mybatis 会将这些参数放在一个map中
     * 以两种方式都可以访问该参数 arg1, arg0, param1, param2
     * 其中 arg0, param1 代表的是第一个参数，剩余的代表第二个参数
     * arg0, param1 其中任意一个都可以代表参数一
     *
     * 若mapper接口方法的参数有多个时，可以手动将这些参数放在map中
     * 通过用户名和密码验证登录
     */
    User checkLogin(String username,String password);
    /**
     * 若mapper接口方法的参数有多个时，可以手动将这些参数放在map中
     * select * from t_user where username=#{username} and password=#{password}
     * 这样就可以从自定义键值对中获取 username=#{username} and password=#{password}
     * 通过用户名和密码验证登录
     */
    User checkLoginV2(Map<String,Object> map);

    /**
     * 使用 @Param 注解来映射参数
     * 通过用户名和密码验证登录
     */
    User checkLoginV3(@Param("username")String username, @Param("password")String password);


    /**
     * 如果参数是一个pojo,参数只需要按照pojo的属性名称进行填充
     * insert into t_user VALUES(null,#{username},#{password},#{age},#{sex},#{email})
     * 添加用户
     */
    int insertUser(User user);

    /**
     * 根据用户名获取员工信息
     *
     */
    User getUserByUserName(String username);

    /**
     * 查询所有员工信息
     */
    List<User> getAllUser();
}
