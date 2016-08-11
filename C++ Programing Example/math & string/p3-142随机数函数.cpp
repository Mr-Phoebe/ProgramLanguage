#include<iostream.h>
#include <stdlib.h>
#include <time.h>

//定义产生[n1,n2]范围int随机数的函数
int rand(int n1,int n2) {
    if (n1>n2) return -1;
    if (n1==n2) return 0;
    int temp=n1+int((n2-n1)*double(rand())/RAND_MAX);
    return temp;
}

//main()函数的定义，加法练习程序
void main( void )
{
     int i;

    //使用当前的系统时间初始化随机数种子
    srand( (unsigned)time( NULL ) );

    //加法练习
    int a,b,c;
    do {
        a=rand(0,20);
        b=rand(0,20);
L1:     cout<<a<<"+"<<b<<"=";
        cin>>c;
        if (c==0) break;
        if (c!=a+b) {
            cout<<"Error! Try again!"<<endl;
            goto L1;
        } 
        cout<<"OK!"<<endl;
    } while (1);

}
