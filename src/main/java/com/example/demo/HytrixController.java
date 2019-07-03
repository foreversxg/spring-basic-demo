package com.example.demo;

import com.example.demo.security.ThreadLocalTest;
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

    @Resource
    private HystrixThreadService hystrixThreadService;

    @RequestMapping(value = "/test/call")
    public String call() {
         hytrixService.call();
        System.out.println( "controller receve:" + System.currentTimeMillis());
        return "OK";

    }


    @RequestMapping(value = "/test/call2")
    public String call2() {
        ThreadLocalTest.set("test-111");
//        System.out.println( "controller receve:" + hystrixThreadService.call2() + ":" + System.currentTimeMillis());
        return hystrixThreadService.call2();
    }
}
