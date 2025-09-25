package com.example.puddingbe.global.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import java.time.Duration;

@Component
public class RedisDao {
    private final RedisTemplate<String, String> redisTemplate;

    public RedisDao(RedisTemplate<String, String> redisTemplate) { // 생성자를 주입해준다
        this.redisTemplate = redisTemplate;
    }

    public void setValues(String key, String value, Duration duration) {
        redisTemplate.opsForValue().set(key, value, duration);
    } // 데이터 (key-value)저장, redis에 정하는 만료시간

    public String getValues(String key) {
        return redisTemplate.opsForValue().get(key);
    } // value 조회 (refresh 토큰 검증시 사용)

//    public void deleteValues(String key) {
//        redisTemplate.delete(key);
//    } // key 삭제 (로그아웃시 refresh 토큰 삭제시 사용)
}
