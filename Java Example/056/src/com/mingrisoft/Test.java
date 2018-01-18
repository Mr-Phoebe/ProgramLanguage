package com.mingrisoft;

public class Test {
    public static void main(String[] args) {
        System.out.println("克隆之前：");
        Address address = new Address("中国", "吉林", "长春");// 创建address对象
        Employee employee1 = new Employee("张XX", 30, address);// 创建employee1对象
        System.out.println("员工1的信息：");
        System.out.println(employee1);// 输出employee1对象
        System.out.println("克隆之后：");
        Employee employee2 = employee1.clone();// 使用克隆创建employee2对象
        employee2.getAddress().setState("中国"); // 修改员工地址
        employee2.getAddress().setProvince("四川"); // 修改员工地址
        employee2.getAddress().setCity("成都"); // 修改员工地址
        employee2.setName("李XX"); // 修改员工名字
        employee2.setAge(24);// 修改员工年龄
        System.out.println("员工1的信息：");
        System.out.println(employee1);// 输出employee1对象
        System.out.println("员工2的信息：");
        System.out.println(employee2);// 输出employee2对象
    }

}
