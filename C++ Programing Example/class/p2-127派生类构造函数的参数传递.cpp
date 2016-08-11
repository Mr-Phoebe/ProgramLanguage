#include<iostream.h>
//定义基类First
class First {
    int  num;
    float grade;
public:
    //构造函数带参数
    First(int n,float v ) : num(n),grade(v)
    {
        cout<<"The First initialized"<<endl;
    }
    DispFirst(void) {
        cout<<"num="<<num<<endl;
        cout<<"grade="<<grade<<endl;
    }
};

//定义派生类Second
class Second :public First {  
    double val;
public:
    //无参数构造函数，要为基类的构造函数设置参数
    Second(void):First(10000,0) {
        val=1.0;
        cout<<"The Second initialized"<<endl;
    }

    //带参数构造函数，为基类的构造函数设置参数
    Second(int n,float x,double dx):First(n,x) {
        val=dx;
        cout<<"The Second initialized"<<endl;
    }
    Disp(char *name){
        cout<<name<<".val="<<val<<endl;
        DispFirst();
    }
};

//main()函数中创建和使用派生类对象
main() {
    //调用派生类的无参数构造函数
	cout<<"Second s1;"<<endl;
    Second s1;
	cout<<"s1.Disp(\"s1\");"<<endl;
	s1.Disp("s1");

    //调用派生类的有参数构造函数
	cout<<"Second s2(10002,95.7,3.1415926); "<<endl;
    Second s2(10002,95.7,3.1415926); 
	cout<<"s2.Disp(\"s2\");"<<endl;	
    s2.Disp("s2");
}
