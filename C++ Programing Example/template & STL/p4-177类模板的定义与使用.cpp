#include<iostream.h>

//定义名为ex_class的类模板
template <class T>  class ex_class
{
    T value;
public:
    ex_class(T v) { value=v; }
    void set_value(T v) { value=v; }
    T get_value(void) {return value;}
};

//main()函数中测试ex_class类模板
void main(void)
{
    //测试int类型数据
    ex_class <int> a(5),b(10);          //声明的时候必须把数据类型具体化
    cout<<"a.value:"<<a.get_value()<<endl;
    cout<<"b.value:"<<b.get_value()<<endl;

    //测试char类型数据
    ex_class <char> ch('A');
    cout<<"ch.value:"<<ch.get_value()<<endl;
    ch.set_value('a');
    cout<<"ch.value:"<<ch.get_value()<<endl;

    //测试double类型数据
    ex_class <double> x(5.5);
    cout<<"x.value:"<<x.get_value()<<endl;
    x.set_value(7.5);
    cout<<"x.value:"<<x.get_value()<<endl;
}
