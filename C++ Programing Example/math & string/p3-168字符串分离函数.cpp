#include<iostream.h>
#include <string.h>

char string[80];
char seps[]   = " ,\t\n";
char *token;

void main( void )
{
    //从键盘上输入两个语句
    for (int i=1;i<3;i++) {
        cout<<"Please input a sentence:"<<endl;
        //整行输入
        cin.getline(string,80);             
        cout<<"Tokens:"<<endl;
        //首次分离字符串
        token = strtok( string, seps );		
        while( token != NULL )              //结束分离判断
        {
            cout<<token<<endl;
            //下次分离字符串
            token = strtok( NULL, seps );   
        }
    }
}
