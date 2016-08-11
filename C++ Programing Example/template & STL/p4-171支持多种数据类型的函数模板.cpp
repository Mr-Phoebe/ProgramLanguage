#include<iostream.h>

//函数模板的原型
template <class T1, class T2> void display(T1 x, T2 y);

//在main()函数中测试display函数模板
void main(void)
{
    //声明变量
    char c='A';
    char str[]="This is a test";
    int n=10;
    float x=1.5;
    double z=3.1415926;

    //两个参数类型相同
    display(c, char(c+2));
    display(str, str);
    display(n, 2*n);
    display(x,2*x);
    display(z, 2*z);
    cout<<"------------------"<<endl;

    //两个参数类型不同
    display(c, str);
    display(str, c);
    display(n, str);
    display(str,2*x);
    display(z, n);
}

//定义名为display的函数模板
template <class T1, class T2> void display(T1 x, T2 y)
{
    cout << x << " " << y << endl;
}
