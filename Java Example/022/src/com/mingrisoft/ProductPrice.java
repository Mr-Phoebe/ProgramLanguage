package com.mingrisoft;

public class ProductPrice {
    public static void main(String[] args) {
        float money = 1170; // 金额
        String rebate = ""; // 折扣
        if (money > 200) {
            int grade = (int) money / 200; // 等级
            switch (grade) { // 根据等级计算折扣比例
                case 1:
                    rebate = "九五折";
                    break;
                case 2:
                    rebate = "九折";
                    break;
                case 3:
                    rebate = "八五折";
                    break;
                case 4:
                    rebate = "八三折";
                    break;
                case 5:
                    rebate = "八折";
                    break;
                case 6:
                    rebate = "七八折";
                    break;
                case 7:
                    rebate = "七五折";
                    break;
                case 8:
                    rebate = "七三折";
                    break;
                case 9:
                    rebate = "七折";
                    break;
                case 10:
                    rebate = "六五折";
                    break;
                default:
                    rebate = "六折";
            }
        }
        System.out.println("您的累计消费金额为：" + money);// 输出消费金额
        System.out.println("您将享受" + rebate + "优惠！"); // 输出折扣比例
    }
}
