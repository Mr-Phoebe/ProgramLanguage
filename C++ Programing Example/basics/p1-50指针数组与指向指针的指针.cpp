#include<iostream>
#include<cstdlib>
using namespace std;
main()
{
    //声明指针数组
    char *colors[]={"Red","Blue","Yellow","Green"}; 
    //指向指针的指针变量
    char **pt;             

    //通过指向指针的变量访问其指向的内容
    pt=colors;
    for (int i=0;i<=3;i++) {
        cout<<"pt="<<pt<<endl;
        cout<<"*pt="<<*pt<<endl;
        cout<<"**pt="<<**pt<<endl;
        pt++;
    }
    system("pause");
}
