#include <iostream.h>
//使用静态变量的计数器函数 
count1() 
{
    //声明静态变量i，并置初值为0。i在count()中局部可见
    static int i=0; 
    return(++i);
}
//使用局部变量的计数器函数  
count2() 
{
    int i=0; 
    return(++i);
}
//在main()函数中调用count()函数
main()  
{
    int i;

    //调用count1()10次
    cout<<"count1():"<<endl;
    for (i=1;i<=12;i++)
         cout<<count1()<<"  ";
    cout<<endl;

    //调用count2()10次
    cout<<"count2():"<<endl;
    for (i=1;i<=12;i++)
         cout<<count2()<<"  ";
    cout<<endl;
}
