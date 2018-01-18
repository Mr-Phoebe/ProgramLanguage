#include <iostream.h>
//定义复数类
class complex{
    float  real;       //实部
    float  image;     //虚部
public:
    //重载的运算符"+"的原型
    complex operator+ (complex right);
    //重载赋值运算符"="的定义
    complex operator= (complex right);
    void set_complex(float re, float im);
    void put_complex(char *name);
};
//重载加法运算符"+"的定义
complex complex::operator+ (complex right) {
    complex temp;
    temp.real = this->real + right.real;
    temp.image = this->image + right.image;
    return temp;
}
//重载加赋值运算符"="的定义
complex complex::operator= (complex right) {   
        this->real = right.real;
        this->image = right.image;
        return *this;
}
//定义set_complex()成员函数
void complex::set_complex(float re, float im) {
        real = re;
        image = im;
}
//定义put_complex()成员函数
void complex::put_complex(char *name) {
        cout<<name<<": ";
        cout << real << ' ';
        if (image >= 0.0 ) cout << '+';
        cout << image << "i\n";
}
//在main()函数中使用complex类的对象
main(void)
{
    complex A, B, C;  //创建复数对象

    //设置复数变量的值
    A.set_complex(1.2, 0.3);
    B.set_complex(-0.5, -0.8);

    //显示复数数据
    A.put_complex("A");
    B.put_complex("B");

    //赋值运算，显示结果
    C = A;
    C.put_complex("C=A");

    //加法及赋值运算，显示结果
    C = A + B;
    C.put_complex("C=A+B");
    return 0;
}
