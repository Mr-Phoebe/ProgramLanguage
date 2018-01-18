package com.minrisoft;

public class Test {
    public static void main(String[] args) {
        System.out.println("克隆之前：");
        Employee employee1 = new Employee();// 创建Employee对象employee1
        employee1.setName("张XX");// 为employee1设置姓名
        employee1.setAge(30);// 为employee1设置年龄
        System.out.println("员工1的信息：");
        System.out.println(employee1); // 输出employee1的信息
        System.out.println("克隆之后：");
        Employee employee2 = employee1; // 将employee1赋值给employee2
        employee2.setName("李XX");// 为employee2设置姓名
        employee2.setAge(24);// 为employee2设置年龄
        System.out.println("员工1的信息：");
        System.out.println(employee1);// 输出employee1的信息
        System.out.println("员工2的信息：");
        System.out.println(employee2);// 输出employee2的信息
    }
}
