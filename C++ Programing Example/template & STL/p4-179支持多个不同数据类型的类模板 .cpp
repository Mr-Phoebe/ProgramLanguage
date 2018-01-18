#include<iostream.h>

//定义名为ex_class的类模板
template <class T1,class T2>  class ex_class
{
    T1 value1;
    T2 value2;
public:
    ex_class(T1 v1,T2 v2) {
        value1=v1;
        value2=v2;
    }
    void set_value(T1 v1,T2 v2) {
        value1=v1;
        value2=v2;
    }
    void put_value(void) {
        cout<<"valu1="<<value1<<endl;
        cout<<"valu2="<<value2<<endl;
    }
};

//main()函数中测试ex_class类模板
void main(void)
{
    //测试int和double类型数据
    ex_class <int,double> a(5,1.5);
    cout<<"ex_class <int,double> a:"<<endl;
    a.put_value();
    a.set_value(100,3.14);
    a.put_value();

    //测试double和int类型数据
    ex_class <double,int> b(0.5,5);
    cout<<"ex_class <double,int> b:"<<endl;
    b.put_value();
    b.set_value(1.732,100);
    b.put_value();

    //测试char和int类型数据
    ex_class <char,int> c('a',5);
    cout<<"ex_class <char,int> c:"<<endl;
    c.put_value();
    c.set_value('B',100);
    c.put_value();

    //测试int和int类型数据
    ex_class <int,int> d(5,10);
    cout<<"ex_class <int,int> d:"<<endl;
    d.put_value();
    d.set_value(100,200);
    d.put_value();
}
