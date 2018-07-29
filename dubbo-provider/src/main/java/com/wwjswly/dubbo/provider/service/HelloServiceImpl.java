package com.wwjswly.dubbo.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.wwjswly.dubbo.api.model.User;
import com.wwjswly.dubbo.api.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @author Javaer
 * @date 2018/7/29
 */
@Service(version = "${demo.service.version}",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class HelloServiceImpl implements HelloService {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public String sayHello(String name) {
        User user = new User();
        user.setAge(12);
        user.setId(00001);
        user.setName(name);
        this.saveUser(user);
        return "Hello, " + name + " (from Spring Boot)";
    }

    @Override
    public void saveUser(User user) {
        mongoTemplate.save(user);
    }

    @Override
    public User findUserByUserName(String userName) {
        return null;
    }

    @Override
    public int updateUser(User user) {
        return 0;
    }

    @Override
    public void deleteUserById(Long id) {

    }
}
