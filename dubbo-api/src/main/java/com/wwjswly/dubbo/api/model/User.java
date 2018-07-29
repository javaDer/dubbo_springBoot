package com.wwjswly.dubbo.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by Javaer on 2018/7/29.
 */
@Document(collection = "T_conversation")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String _id;
    private int id;
    private String name;
    private int age;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User() {
        this._id = _id;
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
