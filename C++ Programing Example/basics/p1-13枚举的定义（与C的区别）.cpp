#include<iostream.h>
main()
{
    //定义枚举类型，并指定其枚举元素的值
    enum color {  
         RED=3,
         YELLOW=6,
         BLUE=9
    };

    //声明枚举变量a和b,并为枚举变量a赋初值 
    enum color a=RED;
    color b;        //合法，与C语言不同

    // 输出枚举常量 
    cout<<"RED="<<RED<<endl;
    cout<<"YELLOW="<<YELLOW<<endl;
    cout<<"BLUE="<<BLUE<<endl;
    
    //枚举变量的赋值和输出
    b=a;
    a=BLUE;
    cout<<"a="<<a<<endl;
    cout<<"b="<<b<<endl;
    //a=100;   错误!
    //a=6      也错误!

    //枚举变量的关系运算
    b=BLUE;                    		// 枚举变量的赋值运算
    cout<<"a<b="<<(a<b)<<endl;
}
