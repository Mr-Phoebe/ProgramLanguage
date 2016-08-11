// p1-851.cpp 为main()函数文件
#include<iostream.h>
main()
{
    int i,s=0;
    extern int fact(int x);
    for (i=2;i<=6;i=i+2)
        s+=fact(i);
    cout<<"s="<<s<<endl;
}
// p1-852.cpp为计算阶乘函数文件
//定义fact()函数为外部(extern)函数
extern int fact(int x)  
{
    int i,t=1;
    if(x==0) return(1);
    for(i=1;i<=x;i++)
        t*=i;
    return(t);
}
