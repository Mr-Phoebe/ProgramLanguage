#include<iostream.h>
#include <string.h>

//main()函数
void main( void )
{
    //声明字符数组
    char ch,string[80],*p;
    int n;

    //输入字符串和要查找的字符
    cout<<"Test strchr():"<<endl;
    cout<<"string:";
    cin>>string;
    cout<<"ch    :";
    cin>>ch;

    //在string中查找ch中的字符并显示
    p=strchr(string,ch);
    cout<<"p    :"<<p<<endl;

    //输入字符串和要查找的字符串并查找
    char substr[80];
    cout<<"Test strstr():"<<endl;
    cout<<"substr:";
    cin>>substr;

    //在string中查找substr中的字符串并显示
    p=strstr(string,substr);
    cout<<"p    :"<<p<<endl;
}
