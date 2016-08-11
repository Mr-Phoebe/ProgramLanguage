#include <iostream.h>
main()
{
    float a,b,s;

    cout<<"a b"<<endl;
    cin>>a>>b;	   //利用cin从键盘上为变量 a,b 赋值
    s=a;
    if (a<b) {
       s=b;         //if语句中只有这一个语句，可省略花括号
    }
    s=s*s;          //变量s中保存a,b中较大的一个数的平方
    cout<<"s="<<s;
}

