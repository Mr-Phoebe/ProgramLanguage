#include<iostream.h>
#include <string.h>

void main( void )
{
    //设置字符串
    char string[] = "Fill the string with something";
    cout<<"string:"<<string<<endl;
    char *p=strset(string,'*');  //把string设置为*
    cout<<"p     :"<<p<<endl;
    cout<<"string:"<<string<<endl;

    //按指定字符和指定数目设置字符数组
    char string1[] = "Fill the string with something";
    cout<<"string1:"<<string1<<endl;
    p=strnset(string1,'*',5);   //将string1的前5个字符设置为*
    cout<<"p    :"<<p<<endl;
    cout<<"string1:"<<string1<<endl;
}
