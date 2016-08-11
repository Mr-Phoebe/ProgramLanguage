#include<iostream.h>
main()
{
    //定义date结构
    struct date
    {
       int year;
       int month;
       int day;
    };

    //定义baby结构
    struct baby
	{
        int    num;
        float   weight;
        date   birthday;   // date为结构类型 
    }; 
	
    //声明baby结构变量并初始化
    baby b1={10001,10,{2002,12,25}};

    //下列是baby结构变量b1的引用。
    cout<<"b1.num="<<b1.num<<endl;
    cout<<"b1.weight="<<b1.weight<<endl;
    cout<<"b1.birthday.year="<<b1.birthday.year<<endl;
    cout<<"b1.birthday.month="<<b1.birthday.month<<endl;
    cout<<"b1.birthday.day="<<b1.birthday.day<<endl;
    cout<<"--------------------------"<<endl;

    //声明baby结构变量temp,并进行赋值运算
    baby temp;
    temp=b1;
    cout<<"temp.num="<<temp.num<<endl;
    cout<<"temp.weight="<<temp.weight<<endl;
    cout<<"temp.birthday.year="<<temp.birthday.year<<endl;
    cout<<"temp.birthday.month="<<temp.birthday.month<<endl;
    cout<<"temp.birthday.day="<<temp.birthday.day<<endl;
}
