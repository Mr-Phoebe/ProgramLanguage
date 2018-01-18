#include<iostream.h>
//定义有两个虚函数的基类
class Base {
public:
    //定义两个虚函数
    virtual void aFn1(void){    
        cout<<"aFnl is in Base class."<<endl;
    }
    virtual void aFn2(void) {    
        cout<<"aFn2 is in Base class."<<endl;
    }
    //定义非虚函数
    void aFn3(void) {    
        cout<<"aFn3 is in Base class."<<endl;
    }
};

//派生类Derived_1中重新定义了基类中的虚函数aFn1
class Derived_1:public Base
{
public:
    void aFn1(void) {   //覆盖aFn1()函数
        cout<<"aFnl is in First derived class."<<endl;
    }
    // void aFn3(void) {   非语法错误，但一般根据类型兼容规则，不这么做
    //    cout<<"aFn3 is in First derived class."<<endl;
    //}
};

//派生类Derived_2中重新定义了基类中的虚函数aFn2
class Derived_2:public Base{
public:
    void aFn2(void){   //覆盖aFn2()函数
        cout<<"aFn2 is in Second derived class."<<endl;
    }
    // void aFn3(void) {   非语法错误，但一般根据类型兼容规则，不这么做
    //    cout<<"aFn3 is in Second derived class."<<endl;
    //}
};
//main()函数的定义
main(void)
{
    //创建和使用基类Base的对象
    Base b;
    cout<<"Base:"<<endl;
    b.aFn1();
    b.aFn2();
    b.aFn3();
    cout<<"----------------------"<<endl;

    //创建和使用派生类Derived_1的对象
    Derived_1 d1;
    cout<<"Derived_1:"<<endl;
    d1.aFn1();
    d1.aFn2();
    d1.aFn3();
    cout<<"----------------------"<<endl;

    //创建和使用派生类Derived_2的对象
    Derived_2 d2;
    cout<<"Derived_2:"<<endl;
    d2.aFn1();
    d2.aFn2();
    d2.aFn3();
}
