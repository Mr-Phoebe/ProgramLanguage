package com.mingrisoft;
public class MultiplicationTable {
    public static void main(String[] args) {
        for(int i=1;i<=9;i++){// 循环控制变量从1遍历到9
            for(int j=1;j<=i;j++){// 第二层循环控制变量与第一层最大索引相等
                // 输出计算结果但不换行
                System.out.print(j+"*"+i+"="+i*j+"\t");
            }
            System.out.println();// 在外层循环中换行
        }
    }
}
