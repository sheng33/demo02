package com.example.demo.domain;

import java.io.Serializable;
import java.sql.Date;

public class Person implements Serializable {
    private int id;
    private String name;
    private Date birth;
    private int age;
    private String zhiwei;

    /**
     * Gets the value of id.
     *
     * @return the value of id
     */

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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getZhiwei() {
        return zhiwei;
    }

    public void setZhiwei(String zhiwei) {
        this.zhiwei = zhiwei;
    }

    @Override
    public String toString() {
        return "Person{" +
                "姓名='" + name + '\'' +
                ", 出生年月=" + birth +
                ", 年龄=" + age +
                ", 职位='" + zhiwei + '\'' +
                '}';
    }
}
