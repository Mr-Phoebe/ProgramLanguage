#include<iostream.h>
//以下为带参数宏替换的预处理指令 
#define  PRINT(k)   cout<<(k)<<endl;
#define  MAX(a,b)   ((a)>(b) ? (a):(b))
main()
{
    int i=3,j=2;

    //MAX(a,b)宏替换的使用 
    cout<<"MAX(10,12)="<<MAX(10,12)<<endl;
    cout<<"MAX(i,j)="<<MAX(i,j)<<endl;
    cout<<"MAX(2*i,j+3)="<<MAX(2*i,j+3)<<endl;

    //PRINT(k)宏替换的使用
    PRINT(5);
    PRINT(MAX(7,i*j));   
}
