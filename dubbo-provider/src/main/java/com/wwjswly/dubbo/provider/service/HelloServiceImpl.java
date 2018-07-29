package com.wwjswly.dubbo.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.wwjswly.dubbo.api.service.HelloService;

/**
 *
 * @author Javaer
 * @date 2018/7/29
 */
@Service(version = "${demo.service.version}",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "Hello, " + name + " (from Spring Boot)";
    }
}
