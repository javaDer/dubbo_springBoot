package com.wwjswly.dubbo.api.dao;

import com.wwjswly.dubbo.api.model.User;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;

import java.util.List;

/**
 * Created by Javaer on 2018/7/29.
 */
public interface UserDao {
    List<User> findAll();

    User getUser(Integer id);

    void update(User user);

    void insert(User user);

    void insertAll(List<User> users);

    void remove(Integer id);

    List<User> findByPage(User user, SpringDataWebProperties.Pageable pageable);
}
