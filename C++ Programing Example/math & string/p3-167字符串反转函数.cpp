#include<iostream.h>
#include <string.h>

//main()函数
void main( void )
{
    //声明字符数组
    char string[80],*p;

    //输入字符串并将其反转
    cout<<"string:";
    cin>>string;
    p=strrev(string );
    cout<<"p     :"<<p<<endl;
    cout<<"string:"<<string<<endl;
}
