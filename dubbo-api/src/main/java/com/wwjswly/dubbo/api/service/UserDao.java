package com.wwjswly.dubbo.api.service;

import com.wwjswly.dubbo.api.model.User;

/**
 * Created by Javaer on 2018-07-29.
 */
public interface UserDao {
    public void saveUser(User user);

    public User findUserByUserName(String userName);

    public int updateUser(User user);

    public void deleteUserById(Long id);

}
