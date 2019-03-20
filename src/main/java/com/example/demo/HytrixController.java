package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2018/12/21
 */
@Controller
public class HytrixController {

    @Resource
    private HytrixService hytrixService;

    @RequestMapping(value = "/test/call")
    public void call() {
        hytrixService.call();
    }
}
