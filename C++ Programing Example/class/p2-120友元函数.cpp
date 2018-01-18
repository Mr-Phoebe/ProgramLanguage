#include<iostream.h>
//Y类的不完全定义
class Y;

//X类的定义    
class X {   
public:
    void disp(Y py,char *name);   //成员函数原型
};

//定义Y类
class Y {  
    //声明本类的友元函数
    //X类的disp()为本例的友元函数
    friend void X::disp(Y py,char *name);
     //普通函数putY() 为本例的友元函数
    friend void putY(Y& yc,char *name);         
private: //私有成员
    int num;
    dispY(char *name){    
        cout<<name<<".num="<<num<<endl;
    }
public: //公共成员函数
    Y(int n){  
       num=n;
    }
};

//X类成员函数的实现部分
void X::disp(Y py,char *name){
    cout<<"In X::disp():"<<endl;
    py.dispY(name);   //访问Y类的私有函数
}

//普通函数putY()的定义
void putY(Y& yc,char *name){
    cout<<"In getY:"<<endl;
    yc.dispY(name);
    cout<<name<<".num=";
    cout<<yc.num<<endl;
}

//在main()函数测试X和Y类的功能
main()
{
    //创建Y和X类的对象
    Y y1(100),y2(200);
    X x;

    //不可用Y类对象的私有成员函数显示
    //y1.dispY("y1");
    //y2.dispY("y2");

    //调用X类对象的友元函数显示
    x.disp(y1,"y1");
    x.disp(y2,"y2");

    //用getY函数显示Y类的对象显示
    putY(y1,"y1");
    putY(y2,"y2");
}
