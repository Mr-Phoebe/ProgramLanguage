package com.mingrisoft;
public class Car {
    private String name;			//表示名称
    private double speed;			//表示速度
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	@Override
    public String toString() {					//重写toString()方法
        StringBuilder sb = new StringBuilder();
        sb.append("车名:" + name + ", ");
        sb.append("速度：" + speed + "千米/小时");
        return sb.toString();
    }
}
