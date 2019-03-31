package com.example.jdbc111.controllor;

import com.example.jdbc111.bean.Dog;
import com.example.jdbc111.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testColtroller {
    @Bean
    public Dog mydog() {
        return new Dog();
    }
    @Autowired
    DepartmentService service;

    @GetMapping
    @RequestMapping("/dog")
    public String getGog() {
        return service.getGogName();
    }

}
