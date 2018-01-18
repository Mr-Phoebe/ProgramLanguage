package com.mingrisoft;

import java.util.Random;
import java.util.TreeSet;

public class RandomSortArray {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<Integer>();// 创建TreeSet集合对象
        Random ran = new Random();// 创建随机数对象
        int count = 0;// 定义随机数计数器
        while (count < 10) {// 循环生成随机数
            boolean succeed = set.add(ran.nextInt(100));// 为集合添加数字
            if (succeed)// 累加成功添加到集合中数字的数量
                count++;
        }
        int size = set.size();// 获取集合大小
        Integer[] array = new Integer[size];// 创建同等大小的数组
        set.toArray(array);// 获取集合中的数组
        System.out.println("生成的重复随机数组内容如下：");
        for (int value : array) {// 遍历输出数组内容
            System.out.print(value + "   ");
        }
    }
}
