package com.mingrisoft;
public class CarFactory {
    public static Car getCar(String name) {
        if (name.equalsIgnoreCase("BMW")) {//如果需要BMW则创建BMW对象
            return new BMW();
        } else if (name.equalsIgnoreCase("Benz")) {//如果需要Benz则创建Benz对象
            return new Benz();
        } else {//暂时不能支持其他车型
            return null;
        }
    }
}
