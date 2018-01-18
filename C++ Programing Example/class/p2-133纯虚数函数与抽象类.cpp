#include<iostream.h>
//定义抽象类
class Base {
public:
    //定义两个纯虚函数
    virtual void aFn1(void)=0;
    virtual void aFn2(void)=0;
};

//派生类Derived_1中覆盖了基类中的纯虚函数
class Derived_1:public Base
{
public:
    void aFn1(void) {
        cout<<"aFnl is in First derived class."<<endl;
    }
    void aFn2(void) {
        cout<<"aFn2 is in First derived class."<<endl;
    }
};

//派生类Derived_2中覆盖了基类中的纯虚函数
class Derived_2:public Base{
public:
    virtual void aFn1(void){
        cout<<"aFn1 is in Second derived class."<<endl;
    }
    void aFn2(void){
        cout<<"aFn2 is in Second derived class."<<endl;
    }
};

//main()函数中测试抽象类及其派生类的对象
main(void)
{
    //用抽象类不能创建对象
    //    Base b;  语法错误
    //    b.aFn1();
    //    b.aFn2();

    //创建和使用Derived_1类的对象
    Derived_1 d1;
    cout<<"Derived_1 d1:"<<endl;
    d1.aFn1();
    d1.aFn2();
    cout<<"------------------"<<endl;

    //创建和使用Derived_2类的对象
    Derived_2 d2;
    cout<<"Derived_2 d2:"<<endl;
    d2.aFn1();
    d2.aFn2();
}
//用抽象类和纯虚函数统一接口