package com.liukai.mybatis.pojo;

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @author liukai
 * @version 1.0
 * @date 2023/9/10 13:02
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Dept implements Serializable {

    private Integer did;
    private String deptName;
    private List<Emp> emps;
}
