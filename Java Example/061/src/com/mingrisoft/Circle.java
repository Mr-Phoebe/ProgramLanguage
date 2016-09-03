package com.mingrisoft;
public class Circle extends Shape {
    private double radius;
    public Circle(double radius) {//获得圆形的半径
        this.radius = radius;
    }
    @Override
    public double getArea() {//计算圆形的面积
        return Math.PI * Math.pow(radius, 2);
    }
}
