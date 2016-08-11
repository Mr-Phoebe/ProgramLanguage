#include<iostream.h>
//以下是几个简单宏替换预处理指令
#define  YES        1
#define  PI         3.1415926
#define  RAD        PI/180
#define  MESG       "This is a string."

//以下是主程序 
main()  {
    //以下各语句使用了宏替换 
    cout<<"YES="<<YES<<endl;
    if (YES) 
       cout<<"PI="<<PI<<endl;
    cout<<"RAD="<<RAD<<endl;
    cout<<MESG<<endl;
}
