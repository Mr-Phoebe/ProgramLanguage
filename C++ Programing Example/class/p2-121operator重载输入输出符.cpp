#include <iostream.h>
//定义日期类
class Date    
{
    //定义友元重载输入运算符函数
    friend istream& operator >> (istream& input,Date& dt ); 
    //定义友元重载输出运算符函数
    friend ostream& operator<< (ostream& output,Date& dt ); 
    int mo, da, yr;
public:
    Date(void){  //无参数构造函数
        yr = 0;
        mo = 0; 
        da = 0; 
    }
    Date( int y, int m, int d )   //带参数构造函数
    {
        yr = y;
        mo = m; 
        da = d; 
    }
};
//定义">>"运算符重载函数
istream& operator >> ( istream& input, Date& dt )
{
    cout<<"Year:";
    input>>dt.yr;
    cout<<"Month:";
    input>>dt.mo;
    cout<<"Day:";
    input>>dt.da;
    return input;
}

//定义"<<"运算符重载函数
ostream& operator<< ( ostream& output, Date& dt )
{
   output<< dt.yr << '/' << dt.mo << '/' << dt.da<<endl;
   return output;
}

//在main()函数中测试Date类的插入（<<）和提取（>>）运算符
void main()
{
    //声明对象
    Date dt1(2002,5,1),dt2;

    //显示dt1对象
    cout<<dt1;

    //对dt2对象进行输入和输出
    cin>>dt2;
    cout<<dt2;
}
