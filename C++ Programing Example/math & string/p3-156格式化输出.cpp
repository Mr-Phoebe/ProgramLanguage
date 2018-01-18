#include<stdio.h>
main()
{
    //输出字符串
    printf("He said \"Hello!\""); 

    //输出各进制整数
    int i=64;
    printf("\ni=%d",i);   				//以十进制格式输出
    printf("\ni=%o",i);    				//以八进制格式输出
    printf("\ni=%x",i);   				//以十六进制格式输出
    printf("\ni=%d,%o,%x",i,i,i);  	   //各种格式混合输出

    //输出浮点数
    float x=3141.5926;
    printf("\nx=%f",x);    //指定输出浮点数的格式为十进制形式
    printf("\nx=%e",x);    //指定输出浮点数的格式为指数形式
 
    //控制输出项宽度
    int j=123;
    printf("\nj=%-10d",j);    	//任选项"-"指定左对齐，W 指定宽度为10
    printf("\nj=%10d\n",j);   	//W 指定宽度为10

    //控制输出精度
    float y=3.1415926;
    printf("y=%10.2f\n",y);   //W 指定宽度为10，P指定小数点后保留2位
    printf("y=%10.5f\n",y);   //W 指定宽度为10，P指定小数点后保留5位
}
