package com.example.jdbc111.service;

import com.alibaba.fastjson.JSON;
import com.example.jdbc111.bean.Department;
import com.example.jdbc111.bean.Dog;
import com.example.jdbc111.mapper.DepartmentMapper;
import com.example.jdbc111.test.test1;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class DepartmentService {
    @Autowired
    DepartmentMapper mapper;
    @Autowired
    RedisTemplate departmentRedisTemplate;

    @Bean
    public Dog mydog() {
        return new Dog();
    }

    @Cacheable(value = "dept")
    public Department getDept(int id) {
        System.out.println("find by id");
        Department department = mapper.getDeptById(id);
        return department;
    }

    @Cacheable(value = "dept")
    public Department getb(Integer id, String name) {
        return mapper.getDeptByIdAndName(id, name);
    }

    public String getGogName() {
        test1 t = new test1();
        return t.dogName();
    }
}
