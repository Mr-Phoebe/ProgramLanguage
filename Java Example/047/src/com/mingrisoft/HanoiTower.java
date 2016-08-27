package com.mingrisoft;

public class HanoiTower {
    public static void moveDish(int level, char from, char inter, char to) {
        if (level == 1) {// 如果只有一个盘子就退出迭代
            System.out.println("从 " + from + " 移动盘子 1 号到 " + to);
        } else {// 如果有大于一个盘子就继续迭代
            moveDish(level - 1, from, to, inter);
            System.out.println("从 " + from + " 移动盘子 " + level + " 号到 " + to);
            moveDish(level - 1, inter, from, to);
        }
    }

    public static void main(String[] args) {
        int nDisks = 3;// 设置汉诺塔为3阶
        moveDish(nDisks, 'A', 'B', 'C');// 实现移动算法
    }
}
