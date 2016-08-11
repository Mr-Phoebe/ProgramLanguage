#include<iostream.h>
//带参数的main()函数
int main(int argc,char *argv[])
{
    int i;
    for(i=0;i<argc;i++)
       cout<<i<<":"<<argv[i]<<endl;
    return 0;
}
