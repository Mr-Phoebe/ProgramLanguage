#include<iostream.h>
//基类First
class First {
    int val1;
public:
    SetVal1(int v) {
        val1=v;
    }
    void show_First(void) {
        cout<<"val1="<<val1<<endl;
    }
};
//派生类Second
class Second:private First {   //默认为private模式
    int val2;
public:
    void SetVal2(int v1,int v2) {
        SetVal1(v1);     //可见，合法
        val2=v2;
    }
    void show_Second(void) {
    // cout<<"val1="<<val1<<endl; 不能访问First私有成员
        show_First();
        cout<<"val2="<<val2<<endl; //自己内部的都可以访问
    }
};
main() {
    Second s1;
    //s1.SetVal1(1);    //不可见，非法
    s1.SetVal2(2,3);    //合法
    //s1.show_First();  //不可见，非法
    s1.show_Second();
}
