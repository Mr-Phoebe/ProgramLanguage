#include<iostream.h>
//定义最低层基类First，它作为其他类的基类
class First {
    int val1;
public:
    First() {
        cout<<"The First initialized"<<endl;
    }
    ~First() {
        cout<<"The First destroyed"<<endl;
    }
};
//定义派生类Second，它作为其他类的基类
class Second :public First {   //默认为private模式
    int val2;
public:
    Second() {
        cout<<"The Second initialized"<<endl;
    }
    ~Second() {
        cout<<"The Second destroyed"<<endl;
    }
};
//定义最上层派生类Three
class Three :public Second {
    int val3;
public:
    Three() {
        cout<<"The Three initialized"<<endl;
    }
    ~Three() {
        cout<<"The Three destroyed"<<endl;
    }
};
//main()函数中测试构造函数和析构函数的执行情况
main() { 
    Three t1;
    cout<<"---- Use the t1----"<<endl;
}
//从子类里辈分最小开始析构
//从基类开始构造