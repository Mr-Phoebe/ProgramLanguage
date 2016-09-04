package com.mingrisoft;
public class Test {
    public static void main(String[] args) {
        Employee employee = new Employee();	//创建Employee对象
        System.out.println(employee.getInfo());	//输出Employee对象的getInfo()方法返回值
        Manager manager = new Manager();		//创建Manager对象
        System.out.println(manager.getInfo());	//输出Manager对象的getInfo()方法返回值
    }
}
