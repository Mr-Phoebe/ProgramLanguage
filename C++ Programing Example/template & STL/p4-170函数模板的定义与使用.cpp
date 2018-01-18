#include<iostream.h>

//定义名为max_value的函数模板
template <class T> T max_value (T a,T b) 
{
    return ((a> b)? a: b);
}

//在main()函数中测试max_value函数模板
void main(void)
{
    //double类型数据使用max_value模板函数
    double x = 1.2, y = 2.1;
    cout<<"x="<<x<<"\t";
    cout<<"y="<<y<<endl;
    double result=max_value(x,y);
    cout<<"max_value(x,y)="<<result<<endl;
    cout<<"max_value(2*3.0,2+3.0)="<<max_value(2*3.0,2+3.0)<<endl;
    cout<<"------------------"<<endl;

    //int类型数据使用max_value模板函数
    int n= 1, m= 6;
    cout<<"n="<<n<<"\t";
    cout<<"m="<<m<<endl;
    cout<<"max_value(n,m)="<<max_value(n,m)<<endl;
    cout<<"------------------"<<endl;

    //char类型数据使用max_value模板函数
    char ch1='A',ch2='a';
    cout<<"ch1="<<ch1<<"\t";
    cout<<"ch2="<<ch2<<endl;
    cout<<"max_value(ch1,ch2)="<<max_value(ch1,ch2)<<endl;
    cout<<"------------------"<<endl;

    //字符串数据使用max_value模板函数
    char str1[]="abc",str2[]="ABC",*p;
    p=max_value(str1,str2);
    cout<<"max_value("<<str1<<","<<str2<<")="<<p<<endl;
}
