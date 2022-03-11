package com.Manage;

public class student {
    private String name;
    private String id;
    private String age;
    private String cla;

    public student() {
        //无参构造
    }

    public student(String name, String id, String age, String cla) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.cla = cla;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCla() {
        return cla;
    }

    public void setCla(String cla) {
        this.cla = cla;
    }
}
