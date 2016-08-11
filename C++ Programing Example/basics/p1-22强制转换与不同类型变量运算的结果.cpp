#include <iostream.h>
main()
{
    //测试表达式类型的转换
    int n=100,m;
    double x=3.791,y;
    cout<<"n*x="<<n*x<<endl;
    
    //赋值类型转换
    m=x;
    y=n;
    cout<<"m="<<m<<endl;
    cout<<"y="<<y<<endl;

    //强制类型转换
    cout<<"int(x)="<<int(x)<<endl;
    cout<<"(int)x="<<(int)x<<endl;
    cout<<"int(1.732+x)="<<int(1.732+x)<<endl;
    cout<<"(int)1.732+x="<<(int)1.723+x<<endl;
    cout<<"double(100)="<<double(100)<<endl;
}
