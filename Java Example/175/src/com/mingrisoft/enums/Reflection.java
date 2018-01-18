package com.mingrisoft.enums;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Reflection {
    public static void main(String[] args) {
        Class<Position> enumClass = Position.class;
        String modifiers = Modifier.toString(enumClass.getModifiers());
        System.out.println("enum类型的修饰符：" + modifiers);
        System.out.println("enum类型的父类：" + enumClass.getSuperclass());
        System.out.println("enum类型的自定义方法：");
        Method[] methods = enumClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }
}
