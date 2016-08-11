#include<iostream.h>

//声明引用参数的函数模板原型
template <class T> void swap(T &x, T &y);

//定义一个结构类型
struct student {
    int n;
    char name[20];
    float grade;
};

//在main()函数中测试swap()函数模板
void main(void)
{
    //交换两个int型变量中的数据
    int m=3,n=5;
    cout<<"m="<<m<<"  n="<<n<<endl;
    swap(m,n);
    cout<<"m="<<m<<"  n="<<n<<endl;
    cout<<"-------------------"<<endl;

    //交换两个double型变量中的数据
    double x=3.5,y=5.7;
    cout<<"x="<<x<<"  y="<<y<<endl;
    swap(x,y);
    cout<<"x="<<x<<"  y="<<y<<endl;
    cout<<"-------------------"<<endl;

    //交换两个char型变量中的数据
    char c1='A',c2='a';
    cout<<"c1="<<c1<<"  c2="<<c2<<endl;
    swap(c1,c2);
    cout<<"c1="<<c1<<"  c2="<<c2<<endl;
    cout<<"-------------------"<<endl;
    
    //交换两个结构变量中的数据
    student s1={1001,"ZhangHua",90};
    student s2={1011,"LiWei",95.5};
    cout<<"s1:  ";
    cout<<s1.n<<"  "<<s1.name<<"  "<<s1.grade<<endl;
    cout<<"s2:  ";
    cout<<s2.n<<"  "<<s2.name<<"  "<<s2.grade<<endl;
    swap(s1,s2);
    cout<<"swap(s1,s2):"<<endl;
    cout<<"s1:  ";
    cout<<s1.n<<"  "<<s1.name<<"  "<<s1.grade<<endl;
    cout<<"s2:  ";
    cout<<s2.n<<"  "<<s2.name<<"  "<<s2.grade<<endl;
}

//定义名为swap的函数模板用于交换两个变量中的数据
template <class T> void swap(T &x, T &y)
{
    T temp;
    temp=x;
    x=y;
    y=temp;
}
