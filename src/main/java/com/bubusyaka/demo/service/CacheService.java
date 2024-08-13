package com.bubusyaka.demo.service;

import com.bubusyaka.demo.model.dto.MostDelayedProviders;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CacheService {

    private final RedisTemplate<String, Serializable> redisTemplate;
    private final RedissonClient redissonClient;

    private List<MostDelayedProviders> cache;

    public void put(List<MostDelayedProviders> value) {

        redisTemplate.opsForValue().set("MostDelayedProviders", (Serializable) value);
        cache = value;
    }

    public List<MostDelayedProviders> get() {
        return (List<MostDelayedProviders>) redisTemplate.opsForValue().get("MostDelayedProviders");
    }

    public void put2(List<MostDelayedProviders> value){
        RLock lock = redissonClient.getLock("lockMostDelayedProviders");

        try {
            lock.lock();
            //  TODO business logic
            redisTemplate.opsForValue().set("MostDelayedProviders", (Serializable) value);
            cache = value;

        } finally {
            lock.unlock();
        }

    }
}
