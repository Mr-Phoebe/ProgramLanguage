include<iostream.h>
main()
{
    //定义结构类型
    struct human {
       char name[10];
       int sex;
       int age;
       };

    //声明结构变量和结构指针,并初始化
    struct human x={"WangPing",1,30},*p=&x;
 
    //利用结构指针显示结构中的数据
    cout<<"(*p).name="<<(*p).name<<endl;
    cout<<"(*p).sex="<<(*p).sex<<endl;
    cout<<"(*p).age="<<(*p).age<<endl;
    cout<<"-------------------------"<<endl;

    //利用new运算符为p分配内存
    p=new human;

    //从键盘上为p指向的结构对象赋值
    cout<<"p->name=";
    cin>>p->name;
    cout<<"p->sex=";
    cin>>p->sex;
    cout<<"p->age=";
    cin>>p->age;
    cout<<"-------------------------"<<endl;

    //显示p所指结构对象的值
    cout<<"p->name="<<p->name<<endl;
    cout<<"p->sex="<<p->sex<<endl;
    cout<<"p->age="<<p->age<<endl;
    cout<<"-------------------------"<<endl;

    //显示结构变量的值
    cout<<"x.name="<<x.name<<endl;
    cout<<"x.sex="<<x.sex<<endl;
    cout<<"x.age="<<x.age<<endl;

    //释放p指向的内存
    delete p;  
}
