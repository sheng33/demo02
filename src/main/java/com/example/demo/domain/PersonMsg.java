package com.example.demo.domain;

import java.sql.Date;

public class PersonMsg {
    private String idname;
    private String password;
    private int power;
    private String name;
    private Date birth;
    private int age;
    private String zhiwei;

    @Override
    public String toString() {
        return "PersonMsg{" +
                "idname='" + idname + '\'' +
                ", password='" + password + '\'' +
                ", 权限=" + power +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                ", age=" + age +
                ", zhiwei='" + zhiwei + '\'' +
                '}';
    }

    public String getIdname() {
        return idname;
    }

    public void setIdname(String idname) {
        this.idname = idname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
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
}
