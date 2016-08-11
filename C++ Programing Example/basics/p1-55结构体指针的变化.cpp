#include<iostream.h>
main()
{
    //定义结构类型
    struct human {
       char name[10];
       int sex;
       int age;
    };

    //声明结构数组和结构指针变量,并初始化
    human x[]={{"WeiPing",1,30},{"LiHua",1,25},{"LiuMin",0,23}},*p=NULL;

    //用下标变量的输出结构数组的元素
    for (int i=0;i<3;i++)
    {
        cout<<x[i].name<<'\t';
        cout<<x[i].sex<<'\t';
        cout<<x[i].age<<endl;
    }
    cout<<"----------------"<<endl;

    //用结构指针输出结构数组的元素
    for (p=x;p<=&x[2];p++)
    {
        cout<<p->name<<'\t';
        cout<<p->sex<<'\t';
        cout<<p->age<<endl;
    }
}
