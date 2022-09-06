package com.redis.boocamp.service;

import com.redis.boocamp.ultis.ApplicationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

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
                    ApplicationUtils.combinePageKey(route), pageUI, 2000, TimeUnit.MILLISECONDS);
    }

    public String getCachePage(String route) {
        if (!cacheRoutes.contains(route)) {
            return "";
        }
        return String.valueOf(redisTemplate.opsForValue().get(ApplicationUtils.combinePageKey(route)));
    }


}
