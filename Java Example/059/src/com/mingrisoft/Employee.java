package com.mingrisoft;

import java.util.Date;		

public class Employee {
    
    private String name;		//员工的姓名
    private double salary;		//员工的工资
    private Date birthday;		//员工的生日
    
    public String getName() {		//获取员工的姓名
        return name;
    }
    
    public void setName(String name) {	//设置员工的姓名
        this.name = name;
    }
    
    public double getSalary() {		//获取员工的工资
        return salary;
    }
    
    public void setSalary(double salary) {	//设置员工的工资
        this.salary = salary;
    }
    
    public Date getBirthday() {		//获取员工的生日
        return birthday;
    }
    
    public void setBirthday(Date birthday) {		//设置员工的生日
        this.birthday = birthday;
    }
    
}
