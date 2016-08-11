#include<stdio.h>
main()
{
    //输入字符串
    char str[80];
    printf("str:");  	//显示提示
    scanf("%s",str);
    printf("The string:%s",str); 

    //输入各进制整数
    int a,b,c,sum;
    printf("\na\tb\tc\n");        	//显示提示
    scanf("%d %o %x",&a,&b,&c); 	//以十进制、八进制、十六进制形式输入数据
    sum=a+b+c;
    printf("a=%d  b=%d  c=%d   sum=%d",a,b,c,sum);

    //输入浮点数并计算显示
    float x,y;          	//声明变量
    printf("\nx\ty\n");        	//显示提示
    scanf("%f %f",&x,&y);     	//对非空白字符"x= y="读入，不保存
    printf("sum=%f  product=%f\n",x+y, x*y);   //显示表达式的值
}
