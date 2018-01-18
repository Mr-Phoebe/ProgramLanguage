#include<iostream.h>
main()
{
    //定义一个包含指针成员的结构类型
    struct test {
       char *str;
       int  *ip;
    } x;

    //使用结构变量x中的整型指针ip
    x.ip=new int;    //分配1个单元
    *(x.ip)=100;
    cout<<"x.ip:"<<x.ip<<'\t'<<*(x.ip)<<endl;
    cout<<"---------------"<<endl;
    delete x.ip;
    x.ip=new int[5];    //分配5个单元
    for(int i=0;i<5;i++)
        *(x.ip+i)=100+i;              //动态分配数组内存
    cout<<"x.ip:"<<endl;
    for(i=0;i<5;i++)
        cout<<x.ip+i<<'\t'<<(*(x.ip+i))<<endl;
    delete x.ip;
    cout<<"---------------"<<endl;

    //使用结构变量x中的字符型指针str
    x.str=new char('A');    //分配1个单元
    cout<<"x.str:"<<(*x.str)<<endl;
    cout<<"---------------"<<endl;
    delete x.str;
    x.str=new char[5];    //分配多个单元
    *x.str='G';
    *(x.str+1)='o';
    *(x.str+2)='o';
    *(x.str+3)='d';
    *(x.str+4)='\0';
    cout<<"x.str:"<<x.str<<endl;
    delete x.str;
    cout<<"---------------"<<endl;

    //在声明结构变量时初始化
    test y={"Very Good!",NULL};
    cout<<"y.str:"<<y.str<<endl;
    cout<<"y.ip:"<<y.ip<<endl;
}
