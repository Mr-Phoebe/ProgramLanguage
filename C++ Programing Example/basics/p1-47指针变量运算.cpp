#include<iostream.h>
main()
{
    //声明数组、变量和指针变量
    int a[]={1,2,3,4,5,6};
    int *ip1,*ip2;

    //测试指针的赋值运算
    ip1=a;
    ip2=ip1;   
    cout<<"*ip1="<<(*ip1)<<endl;
    cout<<"*ip2="<<(*ip2)<<endl;

    //测试指针的自增自减运算和组合运算
    ip1++;  
    ip2+=4; 
    cout<<"*ip1="<<(*ip1)<<endl;
    cout<<"*ip2="<<(*ip2)<<endl;
    
    //测试指针变量之间的关系运算
    int n=ip2>ip1;
    cout<<"ip2>ip1="<<n<<endl;
    cout<<"ip2!=NULL="<<(ip2!=NULL)<<endl;

    //指针变量之间的减法
    n=ip2-ip1;
    cout<<"ip2-ip1="<<n<<endl;
}
