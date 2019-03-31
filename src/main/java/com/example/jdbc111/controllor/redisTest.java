package com.example.jdbc111.controllor;

import com.example.jdbc111.bean.Department;
import com.example.jdbc111.mapper.DepartmentMapper;
import com.example.jdbc111.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class redisTest {
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedisTemplate departmentRedisTemplate;

    @Autowired
    DepartmentService departmentService;

    @RequestMapping("/redis1")
    @GetMapping
    public String redis1() {
        //设置
//        stringRedisTemplate.opsForValue().append("stest", "vall");
        //获取
//       return stringRedisTemplate.opsForValue().get("stest");
//        return "1";
        //给l1这个key左边+1
        stringRedisTemplate.opsForList().leftPush("l1", "1");
        return "1";

    }

    @GetMapping
    @RequestMapping("/redis2")
    public String redis2() {
//        Department dept = departmentMapper.getDeptById(1);
        //使用自己的redisTemplate来把对象转化为json存进去
        departmentRedisTemplate.opsForValue().set("dept1", new Department());
        return "1";
    }

    @GetMapping
    @RequestMapping("/redis3")
    public String redis3(@RequestParam("id") int id, @RequestParam("name") String name) {
        departmentService.getb(id, name);
        return "0";
    }
}
