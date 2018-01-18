#include <iostream>
#include <string>

using namespace std;

//测试字符串(string)对象
void main()
{
    //创建string对象,并显示
    string s1="This";
    string s2="book.";
    cout<<"s1: "<<s1<<endl;
    cout<<"s2: "<<s2<<endl;
    
    //使用length成员函数
    cout<<"s1.length()="<<s1.length()<<endl;
    cout<<"s2.length()="<<s2.length()<<endl;

    //使用append成员函数
    s1.append(s2);
    cout<<"s1: "<<s1<<endl;

    //使用find成员函数和下标运算
    int pos=s1.find('b');
    cout<<"s1["<<pos<<"]="<<s1[pos]<<endl;

    //使用insert成员函数
    s1.insert(pos," is a ");
    cout<<s1<<endl;

    //使用assign成员函数
    s1.assign("Good");
    cout<<s1<<endl;

}
