#include<iostream.h>
void  disp(void);  //这个函数声明语句不能少

//定义main()函数的参数和返回值类型是void类型
void  main(void)  
{
    //调用void类型函数
    disp();  
}
//以下定义disp()函数
void disp(void)  {
     cout<<" You are welcome."<<endl;
}
