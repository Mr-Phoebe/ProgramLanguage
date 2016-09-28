package com.mingrisoft;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] array = new int[5];									//定义长度为5的数组
        Arrays.fill(array, 5);									//将数组中的元素赋值为5
        for (int i = 4; i > -1; i--) {								//遍历整个数组
            if (i == 0) {										// 如果除0
                throw new DivideZeroException("除零异常");		// 如果除零就抛出有异常信息的构造方法
            }												// 如果不是除零就输出结果
            System.out.println("array[" + i + "] / " + i + " = " + array[i] / i);
        }
    }
}
