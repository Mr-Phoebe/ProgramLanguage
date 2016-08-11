#include <iostream.h>  //包含iostream.h头文件
main()
{
    //声明bool变量，并初始化
    bool flag1=false,flag2=true; 
	
    //输出布尔常量和变量
    cout<<"false:"<<false<<endl;
    cout<<"true: "<<true<<endl;
    cout<<"flag1="<<flag1<<endl;
    cout<<"flag2="<<flag2<<endl;

    //布尔变量的赋值和输出
    int x=1;
    flag1=x>0;      //存放关系运算结果
    cout<<"flag1="<<flag1<<endl;
    flag2=flag1;    //bool类型变量相互赋值
    cout<<"flag2="<<flag2<<endl;

    //布尔变量超界处理
    flag1=100; 
    cout<<"flag1="<<flag1<<endl;
    flag2=-100; 
    cout<<"flag2="<<flag2<<endl;
}
