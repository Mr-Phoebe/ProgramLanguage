#include<iostream.h>
//用struct关键字定义ex_class类
struct ex_class
{
    ex_class(int n=1): value(n) {}
    void set_value(int n) {value=n;}
    show_obj(char *name) {cout<<name<<": "<<value<<endl;}
private:
    int value;
}
//测试 ex_class类
main()
{
    //用ex_class创建对象
    ex_class a,b(3);
    
    a.show_obj("a");
    b.show_obj("b");

    a.set_value(100);
    b.set_value(200);

    a.show_obj("a");
    b.show_obj("b");
}