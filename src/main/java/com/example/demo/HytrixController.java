package com.example.demo;

import com.example.demo.spring.prop.InjectPropTest;
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
    @Resource
    private InjectPropTest injectPropTest;


    @RequestMapping(value = "/test/call")
    public String call() {

        injectPropTest.say();
        return "OK";

    }


    @RequestMapping(value = "/test/call2")
    public String call2() {
        System.out.println( "controller receve:"  +hystrixThreadService.call2() + System.currentTimeMillis());
        return "OK";
    }
}
