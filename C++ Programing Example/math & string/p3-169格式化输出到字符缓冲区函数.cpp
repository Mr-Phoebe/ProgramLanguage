#include<iostream.h>
#include<stdio.h>
#include <string.h>

//main()函数
void main( void )
{
    //声明变量和数组
    char  buffer[200], s[] = "computer", c = 'l';
    int   i = 35, j;
    float fp = 1.7320534f;

    //格式化输出到buffer
    j  = sprintf( buffer,     "\tString:    %s\n", s );
    j += sprintf( buffer + j, "\tCharacter: %c\n", c );
    j += sprintf( buffer + j, "\tInteger:   %d\n", i );
    j += sprintf( buffer + j, "\tReal:      %f\n", fp );

    cout<<"Output:"<<endl;
    cout<<buffer;
    cout<<"character count ="<<j<<endl;
}
