package com.redis.boocamp.controller;

import com.redis.boocamp.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cached")
public class PageController {

    @Autowired
    private PageService pageService;

    @RequestMapping("/page/{route}")
    public ResponseEntity<String> getCachePage(@PathVariable String route)
    {
        return ResponseEntity.ok(pageService.getCachePage(route));
    }
}
