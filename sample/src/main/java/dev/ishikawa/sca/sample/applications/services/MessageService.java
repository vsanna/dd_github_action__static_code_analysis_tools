package dev.ishikawa.sca.sample.applications.services;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Component
@AllArgsConstructor
public class MessageService {
    private StringRedisTemplate redisTemplate;

    public void addToList(String key, Object val) {
        Gson gson = new Gson();
        SetOperations<String, String> ops = redisTemplate.opsForSet();
        ops.add(key, gson.toJson(val));
    }

    public <T> List<T> getFromList(String key, Class<T> klass) {
        Gson gson = new Gson();
        SetOperations<String, String> ops = redisTemplate.opsForSet();
        Set<String> result = ops.members(key);
        log.info("result: {}", result);

        if (Objects.isNull(result)) {
            return Collections.emptyList();
        }

        return new ArrayList<>(result).stream().map((val) -> gson.fromJson(val, klass)).collect(Collectors.toList());
    }

    private Optional<String> shouldBeDetected() {
        int a = 1 / 0;
        System.out.println(a);
        return null;
    }
}
