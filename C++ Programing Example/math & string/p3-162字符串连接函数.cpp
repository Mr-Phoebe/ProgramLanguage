#include<iostream.h>
#include <string.h>

void main( void )
{
    //声明字符数组和字符型指针变量
    char string[80],*p;

    //拷贝字符串
    strcpy( string, "I'll see you");
    cout<<"string:"<<string<<endl;

    //追加字符串
    p=strcat( string, " in the morning.");
    cout<<"String: "<<string<<endl;
    cout<<"p     : "<<p<<endl;
}
