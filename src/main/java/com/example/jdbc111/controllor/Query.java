package com.example.jdbc111.controllor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Query {
    @Autowired
    JdbcTemplate jt;
    @GetMapping
    @ResponseBody
    @RequestMapping("/query")
    public String query(){
       return String.valueOf(jt.queryForList("select * from department"));
    }
}
