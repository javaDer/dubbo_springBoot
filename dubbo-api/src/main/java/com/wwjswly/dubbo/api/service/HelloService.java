package com.wwjswly.dubbo.api.service;

/**
 * Created by Javaer on 2018/7/29.
 */
public interface HelloService extends UserDao {
    String sayHello(String name);
}
