package com.mingrisoft;

import java.util.Scanner;
public class JudgeMonth {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);	// 创建扫描器
        // 提示用户输入月份
        System.out.println("请输入一个月份，我能告诉你它属于哪个季节。");
        int month = scan.nextInt();				// 接收用户输入
        switch (month) {						// 判断月份属于哪个季节
            case 12:
            case 1:
            case 2:
                System.out.print("您输入的月份属于冬季。");
                break;
            case 3:
            case 4:
            case 5:
                System.out.print("您输入的月份属于春季");
                break;
            case 6:
            case 7:
            case 8:
                System.out.print("您输入的月份属于夏季");
                break;
            case 9:
            case 10:
            case 11:
                System.out.print("您输入的月份属于秋季");
                break;
            default:
                System.out.print("你那有" + month + "月份吗？");
        }
    }
}
