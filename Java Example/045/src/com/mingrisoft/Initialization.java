package com.mingrisoft;

public class Initialization {
    private byte b; // 声明比特类型变量b
    private short s; // 声明短整型类型变量s
    private int i; // 声明整型类型变量i
    private long l; // 声明长整型类型变量l
    private float f; // 声明单精度浮点类型变量f
    private double d; // 声明双精度浮点类型变量d
    private boolean bl; // 声明布尔类型变量bl
    private char c; // 声明字符类型变量c
    private String string; // 声明引用类型变量string

    public static void main(String[] args) {
        Initialization init = new Initialization();
        System.out.println("比特类型的初始值：" + init.b); // 输出比特类型变量初始值
        System.out.println("短整型类型的初始值：" + init.s); // 输出短整型类型变量初始值
        System.out.println("整型类型的初始值：" + init.i); // 输出整型类型变量初始值
        System.out.println("长整型类型的初始值：" + init.l); // 输出长整型类型变量初始值
        System.out.println("单精度浮点类型的初始值：" + init.f);// 输出单精度浮点类型变量初始值
        System.out.println("双精度浮点类型的初始值：" + init.d);// 输出双精度浮点类型变量初始值
        System.out.println("布尔类型的初始值：" + init.bl); // 输出布尔类型变量初始值
        System.out.println("字符类型的初始值：" + init.c); // 输出字符类型变量初始值
        System.out.println("引用类型的初始值：" + init.string);// 输出引用类型变量初始值
    }
}
