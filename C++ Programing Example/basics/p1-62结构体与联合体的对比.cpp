#include<iostream.h>
main()  
{
    //定义结构类型，并为声明的结构变量赋初值
    struct s_tag {
           short    i;
           float x;
    } sx={100,3.1416};

    //定义联合类型，并为声明的联合变量赋初值
    union   u_tag  {
            short    i;
            float x;
    } ux={1000};

    //输出结构类型和结构变量的有关信息
    cout<<"sizeof(struct s_tag)="<<sizeof(struct s_tag)<<endl;
    cout<<"sx.i="<<sx.i<<endl;
    cout<<"sx.x="<<sx.x<<endl;
    cout<<"sizeof(sx)="<<sizeof(sx)<<endl;
    cout<<"------------------------------"<<endl;

    //输出联合类型和联合变量的有关信息
    cout<<"sizeof(union u_tag)="<<sizeof(union u_tag)<<endl;
    ux.i=200;
    cout<<"ux.i="<<ux.i<<endl;  //输出联合变量ux 的i成员
    ux.x=123.456;
    cout<<"ux.x="<<ux.x<<endl;  //输出联合变量ux 的x成员
    cout<<"sizeof(ux)="<<sizeof(ux)<<endl;
}
