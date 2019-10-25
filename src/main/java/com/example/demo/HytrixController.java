package com.example.demo;

import com.example.demo.security.ThreadLocalTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2018/12/21
 */
@Controller
public class HytrixController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HytrixService.class);
    @Resource
    private HytrixService hytrixService;

    @Resource
    private HystrixThreadService hystrixThreadService;

    @RequestMapping(value = "/test/call")
    public void call() {

        System.out.println( "controller receve:" + hytrixService.call() + ":" + System.currentTimeMillis());
        System.out.println("call end");
    }


    @RequestMapping(value = "/test/call2")
    public void call2() {
        ThreadLocalTest.set("test-111");
        System.out.println( "controller receve:" + hystrixThreadService.call2() + ":" + System.currentTimeMillis());
        System.out.println("call2 end");
    }
}
