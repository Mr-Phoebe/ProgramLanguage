package com.mingrisoft;

public class AppendCharacter {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        String appendStr = "";// 创建字符串变量
        long startTime = System.nanoTime();// 开始记事
        for (int i = 20000; i < 50000; i++) {// 遍历30000个字符
            appendStr += (char) i;// 字符串与每个字符执行连接操作
        }
        long endTime = System.nanoTime();// 结束计时
        System.out.println("String追加字符3万个。");
        // 输出用时
        System.out.println("用时：" + (endTime - startTime) / 1000000d + "毫秒");
        // ///////////////////////////////////////////////////////////////
        StringBuilder strBuilder = new StringBuilder();// 创建字符串构建器
        startTime = System.nanoTime();// 开始计时
        for (int i = 20000; i < 50000; i++) {// 遍历30000个字符
            strBuilder.append((char) i);// 把每个字符追加到构建器
        }
        endTime = System.nanoTime();// 结束记事
        System.out.println("字符串构建器追加字符3万个。");
        // 输出用时
        System.out.print("用时：" + (endTime - startTime) / 1000000d + "毫秒");
    }
    
}
