##include <iostream.h>    //包含iostream.h头文件
void main()
{
									//输出字符常量、变量和字符串
    char c1='A';
    cout<<'W';                      //单引号引用字符
    cout<<c1<<endl;
    cout<<"This is a test."<<endl;  //双引号引用字符串（末尾加'0'）
    cout<<"------------------"<<endl;

									//输出整型常量、变量和表达式
    int n=100;
    cout<<10;
    cout<<n;
    cout<<2*n<<endl;  			   	//输出整型表达式
    cout<<"------------------"<<endl;

									 //输出浮点型常量、变量和表达式
    double pi=3.1415926,r=10.0,s=pi*r*r;
    cout<<pi<<endl;
    cout<<r;
    cout<<s;
    cout<<2*r*pi<<endl;              //输出浮点型表达式
    cout<<"------------------"<<endl;
    
                                     //一个cout可以输出多项数据
    cout<<'W'<<" "<<c1<<endl;
    cout<<"This is a test."<<endl;
    cout<<"pi="<<pi<<" r="<<r<<" s="<<s<<endl;
}
