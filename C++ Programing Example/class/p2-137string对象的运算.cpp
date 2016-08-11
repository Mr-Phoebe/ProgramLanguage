#include <iostream>
#include <string>

using namespace std;

//测试字符串(string)对象
void main()
{

    //创建string对象
    string s1,s2;

    //string对象的赋值运算
    s1="One";
    s2="Two";
    cout<<"s1="<<s1<<endl;
    cout<<"s2="<<s2<<endl;

    //string对象的连接运算
    string s3;
    s3=s1+" and "+s2;
    cout<<"s3="<<s3<<endl;

    //组合赋值连接运算
    s3+=" and Three";
    cout<<"s3="<<s3<<endl;

    //比较运算及其结果显示
    for (int i=1;i<=3;i++) {
        cout<<"---------------------"<<endl;
        cout<<"s1=";
        cin>>s1;
        cout<<"s2=";
        cin>>s2;
        if (s1<s2)   //小于
            cout<<s1<<" < "<<s2<<endl;
        if (s1<=s2)  //小于等于
        cout<<s1<<" <= "<<s2<<endl;
        if (s1==s2)  //等于
        cout<<s1<<" == "<<s2<<endl;
        if (s1>s2)   //大于
        cout<<s1<<" > "<<s2<<endl;
        if (s1>=s2)  //大于等于
        cout<<s1<<" >= "<<s2<<endl;
        if (s1!=s2)  //不等
            cout<<s1<<" != "<<s2<<endl;
    }
}
