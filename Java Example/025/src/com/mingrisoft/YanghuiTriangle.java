package com.mingrisoft;


public class YanghuiTriangle {
    public static void main(String[] args) {
        int triangle[][]=new int[10][];// 创建二维数组
        // 遍历二维数组的第一层
        for (int i = 0; i < triangle.length; i++) {
            triangle[i]=new int[i+1];// 初始化第二层数组的大小
            // 遍历第二层数组
            for(int j=0;j<=i;j++){
                // 将两侧的数组元素赋值为1
                if(i==0||j==0||j==i){
                    triangle[i][j]=1;
                }else{// 其他数值通过公式计算
                    triangle[i][j]=triangle[i-1][j]+triangle[i-1][j-1];
                }
                System.out.print(triangle[i][j]+"\t");         // 输出数组元素
            }
            System.out.println();				//换行
        }
    }
}
