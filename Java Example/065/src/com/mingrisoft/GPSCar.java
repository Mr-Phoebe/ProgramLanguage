package com.mingrisoft;

import java.awt.Point;

public class GPSCar extends Car implements GPS {
    @Override
    public Point getLocation() {						//利用汽车的速度来确定汽车的位置
        Point point = new Point();
        point.setLocation(super.getSpeed(), super.getSpeed());
        return point;
    }
    @Override
    public String toString() {						//重写toString()方法
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", 坐标：(" + getLocation().x + ", " + getLocation().y + ")");
        return sb.toString();
    }
}
