package com.wwjswly.dubbo.consumer.controller;

import com.wwjswly.dubbo.api.service.HelloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;

/**
 * Created by Javaer on 2018/7/29.
 */
@RestController
public class IndexController {
    @Reference(version = "${demo.service.version}",
            application = "${dubbo.application.id}",
            url = "dubbo://127.0.0.1:20880")

    private HelloService helloService;

    @RequestMapping("/say")
    @ResponseBody
    public String register(String name) {
        return helloService.sayHello(name);
    }
}
