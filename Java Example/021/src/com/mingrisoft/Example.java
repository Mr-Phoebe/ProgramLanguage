package com.mingrisoft;

import java.util.*;
public class Example {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入新员工的姓名：");
        String name = scan.nextLine();// 接收员工名称
        System.out.println("请输入新员工应聘的编程语言：");
        String language = scan.nextLine();// 接收员工应聘的编程语言
        // 根据编程语言确定员工分配的部门
        switch (language.hashCode()) {
            case 3254818:// java的哈希码
            case 2301506:// Java的哈希码
            case 2269730:// JAVA的哈希码
                System.out.println("员工"+name+"被分配到Java程序开发部门。");
                break;
            case 3104:// c#的哈希码 
            case 2112:// C#的哈希码 
                System.out.println("员工"+name+"被分配到C#项目维护组。");
                break;
            case -709190099: // asp.net的哈希码 
            case 955463181:  // Asp.net的哈希码 
            case 9745901:    // ASP.NET的哈希码 
                System.out.println("员工"+name+"被分配到Asp.net程序测试部门。");
                break;
            default:
                System.out.println("本公司不需要" + language + "语言的程序开发人员。");
        }
    }
}
