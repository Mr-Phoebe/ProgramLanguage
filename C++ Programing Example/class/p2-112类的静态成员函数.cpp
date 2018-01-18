#include<iostream.h>
//定义一个含有static数据成员的类
class ex
{
    static int num;      //static数据成员
public:
    ex() {num++;}
    ~ex() {num--;}
    static disp_count(void) //static成员函数
    {
        cout<<"The current instances count:";
        cout<<num<<endl;
    }
};
int ex::num=0;    //设置static数据成员的初值
//main()函数测试ex类
main()
{
    ex a;
    a.disp_count();

    ex *p;
    p=new ex;
    p->disp_count();

    ex x[10];
    ex::disp_count();   //直接用类作用域符引用静态成员函数

    delete p;
    ex::disp_count();  //直接用类作用域符引用静态成员函数
}
