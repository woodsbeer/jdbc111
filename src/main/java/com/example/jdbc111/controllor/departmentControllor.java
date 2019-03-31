package com.example.jdbc111.controllor;

import com.example.jdbc111.mapper.DepartmentMapper;
import com.example.jdbc111.bean.Department;
import com.example.jdbc111.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class departmentControllor {
    @Autowired
    DepartmentService departmentService;

    @PostMapping
    @RequestMapping("/dept")
    public int insertFept(Department department) {
//        departmentMapper.insertDept(department);
        return 1;
    }

    @GetMapping
    @RequestMapping("/dept/{id}")
    public Department getDept(@PathVariable int id) {
        return departmentService.getDept(id);
    }
}
