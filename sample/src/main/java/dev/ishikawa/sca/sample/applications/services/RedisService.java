package dev.ishikawa.sca.sample.applications.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class RedisService {
    private StringRedisTemplate redisTemplate;

    public void set(String key, Object val) {
        redisTemplate.opsForValue().set(key, val.toString());
    }

    public String get(String key) {
        String result = redisTemplate.opsForValue().get(key);
        log.info("result: {}", result);
        return result;
    }

}
