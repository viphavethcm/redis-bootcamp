package com.redis.boocamp.service;

import com.redis.boocamp.config.ApplicationConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class PageService {
    private static final List<String> cacheRoutes = Arrays.asList("/about", "/privacy", "/auth/signin", "/auth/signup");

    // inject the actual template
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void setCachePage(String route, String pageUI) {
        if (cacheRoutes.contains(route))
            redisTemplate.opsForValue().set(
                    combineKey(route), pageUI, 2000, TimeUnit.MILLISECONDS);
    }

    public String getCachePage(String route) {
        if (!cacheRoutes.contains(route)) {
            return "";
        }
        return String.valueOf(redisTemplate.opsForValue().get(combineKey(route)));
    }

    private String combineKey(String route)
    {
        return ApplicationConstant.redisPageId + route;
    }
}
