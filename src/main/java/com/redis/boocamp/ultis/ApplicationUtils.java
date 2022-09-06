package com.redis.boocamp.ultis;

import com.redis.boocamp.config.ApplicationConstant;

public class ApplicationUtils {

    public static String combinePageKey(String route)
    {
        return ApplicationConstant.redisPageId + route;
    }
}
