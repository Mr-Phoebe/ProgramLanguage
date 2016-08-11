#include<iostream.h>
#include <string.h>

//字符串输入函数
void str_input(char *p1,char *p2)
{
    cout<<"string1:";
    cin>>p1;
    cout<<"string2:";
    cin>>p2;
}

//显示strcmp()函数的比较结果
void strcmp_put(char *p1,char *p2)
{
    cout<<"strcmp():"<<endl;
    int result=strcmp(p1,p2);
    if (result>0)
        cout<<p1<<" greater than "<<p2<<endl;
    if (result<0)
        cout<<p1<<" less than "<<p2<<endl;
    if (result==0)
        cout<<p1<<" identical to "<<p2<<endl;
}

//显示stricmp()函数的比较结果
void stricmp_put(char *p1,char *p2)
{
    cout<<"stricmp():"<<endl;
    int result=stricmp(p1,p2);        //比较字符串不分大小写
    if (result>0)
        cout<<p1<<" greater than "<<p2<<endl;
    if (result<0)
        cout<<p1<<" less than "<<p2<<endl;
    if (result==0)
        cout<<p1<<" identical to "<<p2<<endl;
}

//显示strncmp()函数的比较结果
void strncmp_put(char *p1,char *p2,size_t count )
{
    cout<<"strncmp():"<<endl;
    int result=strncmp(p1,p2,count);        //比较前N个字符
    if (result>0)
        cout<<p1<<" greater than "<<p2<<endl;
    if (result<0)
        cout<<p1<<" less than "<<p2<<endl;
    if (result==0)
        cout<<p1<<" identical to "<<p2<<endl;
}

//main()函数
void main( void )
{
    //声明字符数组
    char str1[80],str2[80],p;
    int i;

    //测试测试各字符串比较函数
    for(i=1;i<=3;i++) {
        str_input(str1,str2);
        strcmp_put(str1,str2);
        stricmp_put(str1,str2);
        strncmp_put(str1,str2,3);
        cout<<"----------------------"<<endl;
    }
}
