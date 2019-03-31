package com.example.jdbc111.service;

import com.example.jdbc111.bean.Dog;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RabbitService {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    public void sendRabbit() {
        List<String> l = Arrays.asList(new String[]{"1", "2", "3"});
        rabbitTemplate.convertAndSend("direct1", "jiojio", new Dog("ggg"));
    }

    public Object receiveRabbit() {
        return rabbitTemplate.receiveAndConvert("john");
    }

    //放在Service中就可以自动接受
    @RabbitListener(queues = {"john","jiojio"})
    public void autoReceRabbit(Dog dog) {
        System.out.println(dog);
    }



    public void addAmqp() {
        //自己设置一个队列
        amqpAdmin.declareQueue(new Queue("jiojio", true));
        //自己设置一个交换器
        amqpAdmin.declareExchange(new DirectExchange("direct1"));
        //自己设置一个binding（可以设置很多个，全部绑在一个交换器上，或者指向一个队列）
        //参数是队列名，类型-队列，交换器，路由键
        amqpAdmin.declareBinding(new Binding("jiojio", Binding.DestinationType.QUEUE, "direct1", "jiojio", null));
    }
}
