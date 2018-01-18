package com.mingrisoft;

import java.io.Serializable;

public class Student implements Serializable {  // 序列化对象类
    private String id;                  // 类的成员变量
    private String name;// 类的成员变量
    public String getId() { // 成员变量的getter方法
        return id;
    }
    public void setId(String id) {// 成员变量的setter方法
        this.id = id;
    }
    public String getName() {// 成员变量的getter方法
        return name;
    }
    public void setName(String name) {// 成员变量的setter方法
        this.name = name;
    }
}
