package com.example.jdbc111.configuration;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {
    @Bean
    //RabbitTemplate中默认的messageConverter是会乱码的，我们使用可以转化为json的转化器来替代，
    // 在Rabbitmq的配置类中户检测容器中有messageConverter的话就使用容器中的
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
