#include<iostream.h>
#include <string.h>

void main( void )
{
    //拷贝字符串常量到字符数组
    char string[80] = "Fill the string with something";
    cout<<"string:"<<string<<endl;
    cout<<"strcpy:"<<endl;
    char *p=strcpy(string,"abc");
    cout<<"p     :"<<p<<endl;
    cout<<"string:"<<string<<endl;
    char str[80];
    cout<<"str:";
    cin>>str;
    p=strcpy(string,str);
    cout<<"p     :"<<p<<endl;
    cout<<"string:"<<string<<endl;

    //拷贝前5个字符到string中
    cout<<"str:";
    cin>>str;
    cout<<"strncpy:"<<endl;
    p=strncpy(string,str,strlen(str));
    cout<<"p     :"<<p<<endl;
    cout<<"string:"<<string<<endl; 
}
