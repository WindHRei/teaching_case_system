package com.wwf.tcsssoservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author WangWeifeng
 * @date 2020-3-11 下午 4:20
 */
@Configuration
public class CommonConfig {
    @Bean(name = "stringSerializerRedisTemplate")
    public RedisTemplate<String,Object> getStringSerializerRedisTemplate(RedisConnectionFactory factory){
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(factory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        return redisTemplate;
    }
}
