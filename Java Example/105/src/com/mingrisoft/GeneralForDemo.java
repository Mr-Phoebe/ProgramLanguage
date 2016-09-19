package com.mingrisoft;

import java.util.ArrayList;
import java.util.List;

public class GeneralForDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();						// 创建列表
        for (int i = 0; i < 10; i++) {										// 向列表中增加10个元素
            list.add(i);
        }
        System.out.println("列表中的元素：" + list);						// 输出列表中全部的元素
        System.out.println("列表中的奇数序号元素：");
        for (int i = 1; i < list.size(); i += 2) {								// 输出列表中序号为奇数的元素
            System.out.print(list.get(i)+"  ");
        }
    }
}

