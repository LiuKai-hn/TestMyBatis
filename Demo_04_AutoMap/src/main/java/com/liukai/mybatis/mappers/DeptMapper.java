package com.liukai.mybatis.mappers;

import com.liukai.mybatis.pojo.Dept;
import com.liukai.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {

    /**
     * 分步查询的第二步：根据员工所对应的did查询部门信息
     * @param did
     * @return
     */
    Dept getEmpDeptByStep(@Param("did") int did);

    /**
     * 获取部门下有多少个员工
     * @param did
     * @return
     */
    Dept getDeptAndEmps(@Param("did")Integer did);

    /**
     * 通过分步查询部门及部门所有员工信息
     * 分步查询第一步：查询部门信息
     */
    Dept getDeptAndEmpByStepOne(@Param("did")Integer did);

}
