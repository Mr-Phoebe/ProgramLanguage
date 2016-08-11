#include <iostream.h>
main()
{
    //x,y 为操作数，c为运算符
    int x,y,z;
    char c1;
    cin>>x>>c1>>y;   //c1

    //多路选择语句选择不同表达式计算语句
    switch(c1) {
          case '+':cout<<x<<"+"<<y<<"="<<x+y<<endl;
                   break;
          case '-':cout<<x<<"-"<<y<<"="<<x-y<<endl;
                   break;
          case '*':cout<<x<<"*"<<y<<"="<<x*y<<endl;
                   break;
          case '/':cout<<x<<"/"<<y<<"="<<x/y<<endl;
                   break;
          case '%':cout<<x<<"%"<<y<<"="<<x%y<<endl;
                   break;
          default :cout<<"Wrong !"<<endl; //当不符合上述情况时执行本子句
    }
}



