#include <iostream.h>  //包含iostream.h头文件
main()
{
    //字符类型变量的声明
    char c1='A';
    char c2;

    //字符数据的运算及输出
    c2=c1+32;
    cout<<"c1="<<c1<<endl;
    cout<<"c2="<<c2<<endl;

    //输出字符及ASCII码	
    cout<<c1<<" : "<<int(c1)<<endl;
    cout<<c2<<" : "<<int(c2)<<endl;
    cout<<'$'<<" : "<<int('$')<<endl;
	
    //输入字符
    cout<<"c1 c2"<<endl;
    cin>>c1>>c2;
    cout<<"c1="<<c1<<"  c2="<<c2<<endl;
}
