package com.mingrisoft;
public class Manager extends Employee {
    @Override
    public String getInfo() {//重写测试用的方法
        return "子类：我是明日科技的经理！";
    }
}
