package com.example.pudingbe.global.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
    @Value("${spring.data.redis.host}")
    private String host;
    // yml 설정을 가져옴

    @Value("${spring.data.redis.port}")
    private int port;

    @Value("${spring.data.redis.password:}")
    private String password;

    @Bean // redis와 연결하는 객체 생성
    public RedisConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(host);
        redisStandaloneConfiguration.setPort(port);
        if (!password.isEmpty()) {
            redisStandaloneConfiguration.setPassword(password); // 비밀번호 설정
        }
        return new LettuceConnectionFactory(redisStandaloneConfiguration); // 스프링이 redis에 연결할 수 있게 도와줌
        // lettuce vs Jedis? 공부 필요
    }

    @Bean // RedisTemplate -> set get delete redis 명령을 자바로 가능하게 해줌
    public RedisTemplate<String, String> redisTemplate() { // key - value (value 값은 토큰만 저장할거라 String)
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>(); // RedisTemplate 객체생성
        redisTemplate.setConnectionFactory(redisConnectionFactory()); // redis와 통신가능하게 해줌 위에 redisConnectionFactory와 연관
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // 자바 객체를 문자열로 변환 해준다 (key를 직렬화한다)
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        // 토큰만 저장하기엔 Serializer가 적합.

        return redisTemplate;
    }
}
