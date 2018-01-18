#include<iostream.h>
//定义一个全部为public:模式的类
class ex 
{
public:
     int value;
     void set(int n) { 
         value=n;
     }
     int get(void) {
        return value;
     }
};
//测试使用ex类
main()
{
    ex a;    //创建对象

    //以下通过成员函数访问对象数据
    a.set(100);
	cout<<"a.get()=";
    cout<<a.get()<<endl;

    //以下直接访问对象的数据成员
    a.value=200; 
	cout<<"a.value=";
    cout<<a.value<<endl;
}
