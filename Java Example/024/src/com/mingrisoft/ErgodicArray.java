package com.mingrisoft;

public class ErgodicArray {
    public static void main(String[] args) {
        // 创建鸟类数组
        String[] aves = new String[] { "白鹭", "黄鹂", "鹦鹉", "乌鸦", "喜鹊",
                "布谷鸟", "斑鸠", "百灵鸟" };
        int index = 0;// 创建索引变量
        System.out.println("我的花园里有很多鸟，大约包括：");
        while (index < aves.length) {// 遍历数组
            System.out.println(aves[index++]);// 自增索引值
        }
    }
}
