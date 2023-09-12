package com.liukai.mybatis.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liukai.mybatis.mapper.EmpMapper;
import com.liukai.mybatis.pojo.Emp;
import com.liukai.mybatis.pojo.EmpExample;
import com.liukai.mybatis.util.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @Author：liukai
 * @Date：2023/9/12 14:20
 */
public class TestMBG {


    @Test
    public void testMBGSelectALl() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> emps = mapper.selectByExample(null);
        for (Emp emp : emps) {
            System.out.println("emp = " + emp);
        }
    }

    @Test
    public void testMBGSelectALlV2() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        EmpExample empExample = new EmpExample();
        empExample.createCriteria()
                .andEmailEqualTo("120@qq.com")
                .andSexEqualTo("女");
        List<Emp> emps = mapper.selectByExample(empExample);

        for (Emp emp : emps) {
            System.out.println("emp = " + emp);
        }
    }


    @Test
    public void testMBGUpdateV1() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        int cnt = mapper.updateByPrimaryKey(new Emp(2, "ls", 27, "女", "120@qq.com", 3));

        System.out.println("cnt = " + cnt);

    }

    /**
     * 选择性修改：如果为null ，则不修改原来的值
     */
    @Test
    public void testMBGUpdateV2() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        int cnt = mapper.updateByPrimaryKeySelective(new Emp(2, null, 27, null, "120@qq.com", 3));

        System.out.println("cnt = " + cnt);

    }

    /**
     * limit index,pageSize
     * index:当前页的起始索引
     * pageSize：每页显示的条数
     * pageNum：当前页的页码
     * index=(pageNum-1)*pageSize
     * <p>
     * 使用MyBatis的分页插件实现分页功能：
     * 1、需要在查询功能之前开启分页
     * PageHelper.startPage(int pageNum, int pageSize);
     * 2、在查询功能之后获取分页相关信息
     * PageInfo<Emp> page = new PageInfo<>(list, 5);
     * list表示分页数据
     * 5表示当前导航分页的数量
     */

    @Test
    public void testPageHelper() {

        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //Page<Object> page = PageHelper.startPage(2, 4);
        PageHelper.startPage(2, 4);
        List<Emp> list = mapper.selectByExample(null);
        PageInfo<Emp> page = new PageInfo<>(list, 5);
        list.forEach(emp -> System.out.println(emp));
        System.out.println(page);


    }
}
