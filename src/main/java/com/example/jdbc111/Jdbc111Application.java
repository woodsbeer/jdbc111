package com.example.jdbc111;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@MapperScan("com.example.jdbc111.mapper")
@EnableRabbit
@EnableCaching
@SpringBootApplication
public class Jdbc111Application {

    public static void main(String[] args) {
        SpringApplication.run(Jdbc111Application.class, args);
    }

}
