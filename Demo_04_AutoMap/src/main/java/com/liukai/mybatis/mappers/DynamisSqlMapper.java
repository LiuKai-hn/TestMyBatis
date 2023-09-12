package com.liukai.mybatis.mappers;

import com.liukai.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author：liukai
 * @Date：2023/9/12 9:07
 *
 * 动态SQL：
 * 1、if：根据标签中test属性所对应的表达式决定标签中的内容是否需要拼接到SQL中
 * 2、where：
 * 当where标签中有内容时，会自动生成where关键字，并且将内容前多余的and或or去掉
 * 当where标签中没有内容时，此时where标签没有任何效果
 * 注意：where标签不能将其中内容后面多余的and或or去掉
 * 3、trim：
 * 若标签中有内容时：
 * prefix|suffix：将trim标签中内容前面或后面添加指定内容
 * suffixOverrides|prefixOverrides：将trim标签中内容前面或后面去掉指定内容
 * 若标签中没有内容时，trim标签也没有任何效果
 * 4、choose、when、otherwise，相当于if...else if...else
 * when至少要有一个，otherwise最多只能有一个
 * 5、foreach
 * collection:设置需要循环的数组或集合
 * item:表示数组或集合中的每一个数据
 * separator:循环体之间的分割符
 * open:foreach标签所循环的所有内容的开始符
 * close:foreach标签所循环的所有内容的结束符
 * 6、sql标签
 * 设置SQL片段：<sql id="empColumns">eid,emp_name,age,sex,email</sql>
 * 引用SQL片段：<include refid="empColumns"></include>
 */
public interface DynamisSqlMapper {

    /**
     * 多条件查询
     */
    List<Emp> getEmpByCondition(Emp emp);

    List<Emp> getEmpListByWhere(Emp emp);


    List<Emp> getEmpListByTrim(Emp emp);

    List<Emp> getEmpListByChoose(Emp emp);


    int insertMoreEmp(@Param("insertEmps")List<Emp> insertEmps);

    int deleteMoreByArrayV1(@Param("eids")int[] eids);

    int deleteMoreByArrayV2(@Param("eids")int[] eids);

}
