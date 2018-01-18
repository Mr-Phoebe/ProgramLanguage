#include<iostream.h>
main()
{
    int i;
    //定义联合类型
    union utag  {
          char    c;
          int     k;
          float   x;
    };

    //声明联合变量
    union utag u; 

    // 使用联合变量中的字符型成员 
    u.c='*';
    cout<<"u.c="<<u.c<<endl;

    // 使用联合变量中的整型成员 
    u.k=1000;
    cout<<"u.k="<<u.k<<endl;

    // 使用联合变量中的浮点型成员 
    u.x=3.1416;
    cout<<"u.x="<<u.x<<endl;

    //声明联合变量时初始化
    utag u1={'A'};

    //同时引用联合变量的各成员
    cout<<"u1.c="<<u1.c<<endl;
    cout<<"u1.k="<<u1.k<<endl;
    cout<<"u1.x="<<u1.x<<endl;
}
