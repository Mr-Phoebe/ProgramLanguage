#include<iostream.h>
//声明全局变量并初始化
extern int a[]={1,2,3};
extern float p=3.14;

//在show()函数中使用外部变量
show()
{
    int i;
    cout<<"In show():"<<endl;
	cout<<"p="<<p<<endl;
	cout<<"a[]: ";
    for (i=0;i<=2;i++) 
        cout<<a[i]<<"  ";
    cout<<endl;
    //cout<<"y="<<y<<endl; 编译出错！
}

//声明外部变量并初始化
int y=5678;

//在main()函数中使用外部变量
main()  
{
    //声明局部变量
    int i,p=100;

    //显示重名变量
	cout<<"In main():"<<endl;
    cout<<"p="<<p<<endl;

    //显示全局变量
    cout<<"::p="<<::p<<endl;
	cout<<"a[]: ";
    for (i=0;i<=2;i++)
        cout<<a[i]<<"  ";
    cout<<endl;
    cout<<"y="<<y<<endl;   //编译正确！

    show();  //调用函数
}
