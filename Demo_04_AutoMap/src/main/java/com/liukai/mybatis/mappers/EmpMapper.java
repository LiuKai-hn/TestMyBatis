package com.liukai.mybatis.mappers;

import com.liukai.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liukai
 * @version 1.0
 * @date 2023/9/10 13:03
 */
public interface EmpMapper {

    /**
     * 查询所有的员工信息
     */
    List<Emp> getAllEmp();

    /**
     * 查询员工信息以及员工所对应的部门信息
     */

    Emp getEmpAndDeptByEid(@Param("eid") int eid);

    /**
     * 通过分步查询查询员工所对应的部门信息
     * 第一步 查询用户信息
     * @param eid
     * @return
     */
    Emp getEmpByStepOne(@Param("eid") int eid);
}
