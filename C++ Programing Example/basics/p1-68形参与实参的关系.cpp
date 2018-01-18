#include<iostream.h>
//定义f()函数
f(int x,int y)     //f()的参数以值方式传递
{
    ++x;
    --y;
    cout<<"x="<<x<<",y="<<y<<endl;
}
main()  {
    int a,b;

    //设置实际参数的值
    a=b=10;
    //以变量为参数调用f()函数
    f(a,b);

    //验证实际参数的值
    cout<<"a="<<a<<",b="<<b<<endl;

    //以表达式参数形式调用f()函数
    f(2*a,a+b);
}
