#include<iostream.h>

//定义输入函数模板
template <class T> void input(char *str,T &x) {
    cout<<str<<"=";
    cin>>x;
}

//定义输出函数模板
template <class T> void output(char *str,T x) {
    cout<<str<<"="<<x<<endl;
}

//在main()函数中测试输入输出函数模板
void main(void)
{
    //输入输出int型数据
    int a,b;
    input("a",a);
    output("a",a);
    b=3*a;
    output("3*a",b);
    output("a+b",a+b);
    cout<<"-------------------"<<endl;

    //输入输出double型数据
    double x,y;
    input("x",x);
    output("x",x);
    y=2*x;
    output("y",y);
    cout<<"-------------------"<<endl;

    //输入输出char型数据
    char c1;
    input("c1",c1);
    output("c1+2",char(c1+2));
    cout<<"-------------------"<<endl;

    //输入输出字符串数据
    char string[80];
    input("string",string);
    output("string",string);
}
