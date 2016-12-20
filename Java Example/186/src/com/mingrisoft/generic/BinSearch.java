package com.mingrisoft.generic;

import java.util.Arrays;

public class BinSearch {
    public static <T extends Comparable<? super T>>  int search(T[] array, T key) {
        int low = 0;
        int mid = 0;
        int high = array.length;
        System.out.println("查找的中间值：");
        while (low <= high) {
            mid = (low + high) / 2;
            System.out.print(mid+" ");
            if (key.compareTo(array[mid]) > 0) {
                low = mid + 1;
            } else if (key.compareTo(array[mid]) < 0) {
                high = mid - 1;
            } else {
                System.out.println();
                return mid;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        Integer[] ints = {1,2,3,4,5,6,7,8,9,10};
        System.out.println("数据集合：");
        System.out.println(Arrays.toString(ints));
        System.out.println("元素3所对于的索引序号："+search(ints, 3));
    }
}
