package com.mingrisoft.generic;

public class GenericArrayTest {
    public static void main(String[] args) {
        System.out.println("创建String类型的数组并向其添加元素：明日科技");
        GenericArray<String> stringArray = new GenericArray<String>(String.class, 10);
        stringArray.put(0, "明日科技");
        System.out.println("String类型的数组元素：" + stringArray.get(0));
        System.out.println("创建Integer类型的数组并向其添加元素：123456789");
        GenericArray<Integer> integerArray = new GenericArray<Integer>(Integer.class, 10);
        integerArray.put(0, 123456789);
        System.out.println("Integer类型的数组元素：" + integerArray.get(0));
    }
}
