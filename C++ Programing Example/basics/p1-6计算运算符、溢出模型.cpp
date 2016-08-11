#include <iostream.h>  //包含iostream.h头文件
main()
{
    //声明整型变量
    int a,b; 

    //从键盘上为整型变量赋值
    cout<<"a=";
    cin>>a;
    cout<<"b=";
    cin>>b;

    //整型数的算术运算
    cout<<a<<"+"<<b<<"="<<a+b<<endl;
    cout<<a<<"-"<<b<<"="<<a-b<<endl;
    cout<<a<<"*"<<b<<"="<<a*b<<endl;
    cout<<a<<"/"<<b<<"="<<a/b<<endl;
    cout<<a<<"%"<<b<<"="<<a%b<<endl;

    //测试溢出
    short n=32767,m;    //n取short类型的最大值
    cout<<"n="<<n<<endl;
    m=n+1;      //引起溢出
    cout<<"n+1="<<m<<endl;
}
