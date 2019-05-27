package com.example.demo.aop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/5/15
 */
@Controller
public class AopController {

    @Resource
    private MultiAsp multiAsp;

    @RequestMapping(value = "/test/aop")
    public void call() {
        multiAsp.test();
    }
}
