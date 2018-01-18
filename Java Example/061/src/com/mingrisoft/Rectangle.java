package com.mingrisoft;
public class Rectangle extends Shape {
    private double length;
    private double width;
    public Rectangle(double length, double width) {//获得矩形的长和宽
        this.length = length;
        this.width = width;
    }
    @Override
    public double getArea() {//计算矩形的面积
        return length * width;
    }
}
