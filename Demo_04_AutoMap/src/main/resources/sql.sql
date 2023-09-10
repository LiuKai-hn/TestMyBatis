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
  PRIMARY KEY (`eid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `t_dept` (
  `did` int NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;