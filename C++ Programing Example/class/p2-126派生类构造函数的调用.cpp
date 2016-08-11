#include<iostream.h>
//定义最低层基类，它作为其他类的基类
class First {
    int val1;
public:
    First(void) {
        cout<<"The First initialized"<<endl;
    }
};
//定义派生类，它作为其他类的基类
class Second :public First {   
    int val2;
public:
    Second(void) {
        cout<<"The Second initialized"<<endl;
    }
};
//定义最上层派生类
class Three :public Second {
    int val3;
public:
    Three() {
        cout<<"The Three initialized"<<endl;
    }
};
//定义各基类的对象，测试构造函数的执行情况
//定义各基类的对象，测试构造函数的执行情况
main() { 
	cout<<"First f1;"<<endl;
    First f1;
    cout<<"Second s1;"<<endl;
    Second s1;
    cout<<"Three t1;"<<endl;
    Three t1;
}
