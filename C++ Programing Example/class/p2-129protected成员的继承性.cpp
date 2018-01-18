#include<iostream.h>
//基类
class First {
    int val1;
protected:
    void SetVal1(int v) {
        val1=v;
    }
public:
    show_First(void) {
        cout<<"val1="<<val1<<endl;
    }
};
//派生类
class Second:public First {   
    int val2;
protected:
    void SetVal2(int v) {
        SetVal1(v);  //使用First 基类的保护成员
        val2=v;
    }
public:
    show_Second(void) {
        show_First();
        cout<<"val2="<<val2<<endl;
    }
};
//派生类
class Third:public Second {   
    int val3;
public:
    void SetVal3(int n) {
         SetVal1(n);  //使用First 基类的保护成员
         SetVal2(n);  //使用Second基类的保护成员
         val3=n;
    }
    show_Third(void) {
        show_Second();
        cout<<"val3="<<val3<<endl;
    }
};
//main()函数的定义
main(void)
{
    First f1;
    //f1.SetVal1(1);   不可访问

    Second s1;
    //s1.SetVal1(1);   不可访问
    //s1.SetVal2(2);   不可访问

    Third  t1;
    //t1.SetVal1(1);   不可访问
    //t1.SetVal2(2);   不可访问
    t1.SetVal3(10);

	//显示t1对象的数据
	cout<<"t1.show_Third();"<<endl;
    t1.show_Third();
    cout<<"t1.show_Second();"<<endl;
    t1.show_Second();
    cout<<"t1.show_First();"<<endl;
    t1.show_First();
}
//公有继承类、保护继承类可以访问
//对象不能直接访问