package com.example.jdbc111.controllor;

import com.example.jdbc111.bean.Dog;
import com.example.jdbc111.service.RabbitService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListeners;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Rabbitmq {
    @Autowired
    RabbitService rabbitService;

    @RequestMapping("/rabbit")
    @GetMapping
    public String rebbit() {
        rabbitService.sendRabbit();
        return "ok";
    }

    //手动获取队列的值
    @RequestMapping("/rabbitRece")
    @GetMapping
    public Object rebbitRece() {
        return rabbitService.receiveRabbit();
    }

    @RequestMapping("/addAmqp")
    @GetMapping
    public String addAmqp() {
        rabbitService.addAmqp();
        return "add";
    }
}
