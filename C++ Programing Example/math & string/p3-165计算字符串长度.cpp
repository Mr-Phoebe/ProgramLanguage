#include<iostream.h>
#include <string.h>

//main()函数
void main( void )
{
    //声明字符数组
    char string[]="This is a test.";
    int n;

    //获得字符串的长度
    cout<<"string:"<<string<<endl;
    n=strlen(string);
    cout<<"The length of "<<"\""<<string<<"\": "<<n<<endl;

    //输入字符并计算其长度
    cout<<"string:";
    cin>>string;
    n=strlen(string);
    cout<<"The length of "<<"\""<<string<<"\": "<<n<<endl;
}
