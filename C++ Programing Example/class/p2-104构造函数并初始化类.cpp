#include<iostream.h>
main()
{
    //定义一个名为student的类
    class student {
          int num;
          char *name;
          float grade;
    public:
         //定义构造函数
        student(int n,char *p,float g): num(n),name(p),grade(g){}
        display(void) {
              cout<<num<<" ,"<<name<<","<<grade<<endl;
          }
    }; 

    student a(1001,"Liming",95),b(1002,"ZhangHua",96.5);   //创建对象，并初始化
    //student c;  错误，没提供参数

    a.display();            //显示对象a中的数据
    b.display();            //显示对象b中的数据
}
