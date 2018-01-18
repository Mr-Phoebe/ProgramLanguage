#include<iostream.h>
//函数原型语句可以在这里
//定义main()函数 
main()  
{
    //max()函数原型声明语句
    float max(float,float);
	
    //变量声明语句
    float a,b,Max;

    //输入参数并计算
    cout<<"a=";
    cin>>a;
    cout<<"b=";
    cin>>b;
    Max=max(a,b);     //调用max()函数 
    cout<<"max("<<a<<","<<b<<")="<<Max<<endl;
}
//定义max()函数
float max(float x,float y)     //max()返回值类型为浮点型
{
    float z;
    z=(x>y)?x:y;
    return(z);
}

