#include<iostream>
using namespace std;
main()
{
    //声明字符型数组和指针变量
    char str[10];
    char *strip=str;

    //输入输出
    cout<<"str=";
    cin>>str;      //用字符数组输入字符串
    cout<<"str="<<str<<endl;
    cout<<"strip="<<strip<<endl;
    cout<<"strip=";
    cin>>strip;     //用字符指针变量输入字符串
    cout<<"str="<<str<<endl;
    cout<<"strip="<<strip<<endl;

    //利用指针变量改变其指向字符串的内容
    *(strip+2)='l';
    cout<<"str="<<str<<endl;
    cout<<"strip="<<strip<<endl;

    //动态为字符型指针变量分配内存
    strip=new char(100);
    cout<<"strip=";
    cin>>strip; //用字符指针变量输入字符串
    cout<<"str="<<str<<endl;
    cout<<"strip="<<strip<<endl;
    delete strip;
}
