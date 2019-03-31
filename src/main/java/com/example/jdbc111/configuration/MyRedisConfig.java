package com.example.jdbc111.configuration;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import com.example.jdbc111.bean.Department;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.session.SessionProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.net.UnknownHostException;
import java.util.List;

@Configuration
public class MyRedisConfig {
    @Bean
    public RedisTemplate<Object, Department> departmentRedisTemplate(
            RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, Department> template = new RedisTemplate<>();
        //注意这里使用阿里的一个json转化包，这个比较好
        template.setDefaultSerializer(new FastJsonRedisSerializer<>(Department.class));
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    //RedisCacheConfigration中的manager也是使用默认的序列化方式，我们改一下源码中的bean
    //容器中默认的manager判断容器中没有departmentRedisTemplate才生效的，我们这里定义他就不会生效
    @Bean
    public RedisCacheManager deptCacheManager(RedisTemplate<Object, Department> departmentRedisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(departmentRedisTemplate);
       //将cachename作为前缀
        cacheManager.setUsePrefix(true);
        return cacheManager;
    }
}
