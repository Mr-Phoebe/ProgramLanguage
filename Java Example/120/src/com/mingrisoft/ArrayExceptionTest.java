package com.mingrisoft;

import java.util.Arrays;

public class ArrayExceptionTest {
    public static void main(String[] args) {
        int[] array = new int[5]; // 声明一个长度为5的整型数组
        Arrays.fill(array, 8); // 将新声明的数组所有元素赋值为8
        for (int i = 0; i < 6; i++) {// 遍历输出所有数组元素
            System.out.println("array[" + i + "] = " + array[i]);
        }
    }
}
