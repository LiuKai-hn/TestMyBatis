create database mybatis;
use mybatis;


CREATE TABLE `t_user` (
                          `id` int NOT NULL AUTO_INCREMENT,
                          `username` varchar(20) DEFAULT NULL,
                          `password` varchar(20) DEFAULT NULL,
                          `age` int DEFAULT NULL,
                          `sex` char(1) DEFAULT NULL,
                          `email` varchar(20) DEFAULT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



select * from t_user;

select * from t_user where username='lk';


CREATE TABLE `t_emp` (
  `eid` int NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(100) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `did` int DEFAULT NULL,
  PRIMARY KEY (`eid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `t_dept` (
  `did` int NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;



INSERT INTO mybatis.t_dept (did, dept_name) VALUES (1, 'A');
INSERT INTO mybatis.t_dept (did, dept_name) VALUES (2, 'B');
INSERT INTO mybatis.t_dept (did, dept_name) VALUES (3, 'C');

INSERT INTO mybatis.t_emp (eid, emp_name, age, sex, email, did) VALUES (1, 'zs', 25, '男', '110@qq.com', 1);
INSERT INTO mybatis.t_emp (eid, emp_name, age, sex, email, did) VALUES (2, 'ls', 26, '女', '120@qq.com', 2);
INSERT INTO mybatis.t_emp (eid, emp_name, age, sex, email, did) VALUES (3, 'ww', 25, '男', '120@qq.com', 3);
INSERT INTO mybatis.t_emp (eid, emp_name, age, sex, email, did) VALUES (4, 'zl', 26, '女', '120@qq.com', 1);
INSERT INTO mybatis.t_emp (eid, emp_name, age, sex, email, did) VALUES (5, 'tq', 28, '男', '120@qq.com', 2);


select * from t_dept left join t_emp on t_dept.did=t_emp.did;



select * from t_emp;



