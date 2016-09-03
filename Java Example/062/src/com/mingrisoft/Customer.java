package com.mingrisoft;
public class Customer {
    public static void main(String[] args) {
        System.out.println("顾客要购买BMW:");
        Car bmw = CarFactory.getCar("BMW");		//用户要购买BMW
        System.out.println("提取汽车：" + bmw.getInfo());	//提取BMW
        System.out.println("顾客要购买Benz:");
        Car benz = CarFactory.getCar("Benz");	//用户要购买Benz
        System.out.println("提取汽车：" + benz.getInfo());//提取Benz
    }
}

