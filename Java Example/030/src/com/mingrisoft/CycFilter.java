package com.mingrisoft;
public class CycFilter {
    public static void main(String[] args) {
        // 创建数组
        String[] array = new String[] { "白鹭", "丹顶鹤", "黄鹂", "鹦鹉", "乌鸦", "喜鹊",
                "老鹰", "布谷鸟", "老鹰", "灰纹鸟", "老鹰", "百灵鸟" };
        System.out.println("在我的花园里有很多鸟类，但是最近来了几只老鹰，请帮我把它们抓走。");
        int eagleCount = 0;
        for (String string : array) {// foreach遍历数组
            if (string.equals("老鹰")) {// 如果遇到老鹰
                System.out.println("发现一只老鹰，已经抓到笼子里。");
                eagleCount++;
                continue;// 中断循环
            }
            System.out.println("搜索鸟类，发现了：" + string);// 否则输出数组元素
        }
        System.out.println("一共捉到了：" + eagleCount + "只老鹰。");
    }
}
