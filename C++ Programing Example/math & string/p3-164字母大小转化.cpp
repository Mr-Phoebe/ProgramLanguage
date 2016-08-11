#include<iostream.h>
#include <string.h>

//main()函数
void main( void )
{
    //声明字符数组
    char string[80],*p;
    int i;

    //转换字符串中的小写字母为大写
    cout<<"Convert a string to uppercase:"<<endl;
    cout<<"string:";
    cin>>string;
    p=strupr(string);
    cout<<"p:"<<p<<endl;
    cout<<"string:"<<string<<endl;
    cout<<"----------------------"<<endl;

    //转换字符串中的大写字母为小写
    cout<<"Convert a string to lowercase:"<<endl;
    cout<<"string:";
    cin>>string;
    p=strlwr(string);
    cout<<"p:"<<p<<endl;
    cout<<"string:"<<string<<endl;
}
