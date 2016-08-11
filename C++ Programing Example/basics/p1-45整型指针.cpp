#include<iostream.h>
main()
{
    //声明变量和指针变量
    int a,b,c,*ip;

    //指针变量ip指向变量a
    a=100;
    ip=&a;        //使指针变量 ip 指向变量a
    cout<<"a="<<a<<endl;
    cout<<"*ip="<<*ip<<endl;
    cout<<"ip="<<ip<<endl;

    //指针变量ip指向变量b
    ip=&b;        //使指针变量 ip 指向变量b
    b=200;
    cout<<"b="<<b<<endl;
    cout<<"*ip="<<*ip<<endl;
    cout<<"ip="<<ip<<endl;

    //指针变量ip指向变量c
    ip=&c;        //使指针变量 ip 指向变量b
    *ip=a+b;
    cout<<"c="<<c<<endl;
    cout<<"*ip="<<*ip<<endl;
    cout<<"ip="<<ip<<endl;
}
