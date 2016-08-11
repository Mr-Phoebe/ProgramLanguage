#include <iostream.h>
class ex_class {
    int value;
public:
    ex_class(int n) {
        value=n;
        cout << "Stack initialized." << endl;
    }
    ~ex_class() {    
        cout << "The Object destroyed." <<endl;  
    }
    void set_value(int n);
    void show_val(char *name);
} ;

//在类外定义内联成员函数
inline void ex_class::set_value(int n) {
    value=n;
}
//在类外定义非内联成员函数
void ex_class::show_val(char *name) {
	cout<<name<<": ";
    cout<<value<<endl;
}
//在main()函数中测试ex_class类
main(void)
{
    //创建对象x和y
    ex_class x(100),y(200);

    //显示对象的数据
    x.show_val("x");
    y.show_val("y");

    //设置新值给对象
    x.set_value(1);
    y.set_value(2);

    //显示对象的数据
    x.show_val("x");
    y.show_val("y");

    return 0;
}
