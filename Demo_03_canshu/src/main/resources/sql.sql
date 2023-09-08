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