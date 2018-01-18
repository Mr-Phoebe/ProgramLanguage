#include<iostream.h>
#define   PI   3.1416
main()
{
    int i=100;
#if 1                     //当#if后的为真，则进行编译，为假则不编译
    cout<<"i="<<i<<endl;
#endif                    //结束条件编译

#ifdef PI                 //如果宏定义了PI，则编译
    cout<<"1  PI="<<PI<<endl;
#endif

#ifndef PI				  //如果没有宏定义PI，则编译
    cout<<"2  PI="<<PI<<endl;   //此语句不被编译执行
#endif
}
