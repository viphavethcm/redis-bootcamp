package com.redis.boocamp;

import com.redis.boocamp.service.PageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BootcampApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private PageService pageService;

    @Test
    public void getPage()
    {
        String route = "/about";
        String pageUI = pageService.getCachePage(route);
        System.out.println(pageUI);
    }
}
