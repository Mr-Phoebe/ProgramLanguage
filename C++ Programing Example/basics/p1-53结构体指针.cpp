#include<iostream.h>
main()
{
    //定义结构类型
    struct human {
       char name[10];
       int sex;
       int age;
    };

    //声明结构变量和结构指针变量,并初始化
    struct human x={"WangPing",1,30},*p=NULL;

    //结构指针变量指向对象
    p=&x;

    //显示结构变量的值
    cout<<"x.name="<<x.name<<endl;
    cout<<"x.sex="<<x.sex<<endl;
    cout<<"x.age="<<x.age<<endl;
  
    //利用结构指针显示结构对象中的数据
    cout<<"(*p).name="<<(*p).name<<endl;
    cout<<"(*p).sex="<<(*p).sex<<endl;
    cout<<"(*p).age="<<(*p).age<<endl;
    cout<<"p->name="<<p->name<<endl;
    cout<<"p->sex="<<p->sex<<endl;
    cout<<"p->age="<<p->age<<endl;

    //通过结构指针为结构对象输入数据
    cout<<"name:";
    cin>>(*p).name;
    cout<<"sex:";
    cin>>(*p).sex;
    cout<<"age:";
    cin>>(*p).age;

    //显示结构变量的值
    cout<<"x.name="<<x.name<<endl;
    cout<<"x.sex="<<x.sex<<endl;
    cout<<"x.age="<<x.age<<endl;
}
