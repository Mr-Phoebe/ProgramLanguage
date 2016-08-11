#include<iostream.h>
//定义ex类
class ex_class 
{
    int a;
    double b; 
public:
    ex_class(int n=1,double x=1.0):a(n),b(x) {}
    void show_value(char *name) {
        cout<<name<<" :"<<endl;
        cout<<"a="<<a<<endl;
        cout<<"b="<<b<<endl;
    }
};

//定义main()函数
main()
{
    //创建ex_class的对象并显示
    ex_class obj1,obj2(100,3.5);    
    obj1.show_value("obj1");
    obj2.show_value("obj2"); 

    //创建ex_class的指针变量
    ex_class *p;

    //p指向obj1并显示
    p=&obj1;
    p->show_value("p->obj1");

    //p指向obj2并显示
    p=&obj2;
    (*p).show_value("(*p)obj2");

    //p指向动态创建的对象并显示
    p=new ex_class;
    p->show_value("p->new");

    delete p;   //删除对象

}
