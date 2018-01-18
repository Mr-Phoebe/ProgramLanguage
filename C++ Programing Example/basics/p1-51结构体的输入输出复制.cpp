#include<iostream>
#include<cstdlib>
using namespace std;
main()
{
    //定义结构类型
    struct    books
    {
    char   title[20];
    char   author[15];
    int    pages;
    float  price;
    } ;
    
    //声明结构变量
    struct books Zbk={"VC++ ","Zhang",295,35.5}; 
    books Wbk;  

    //对结构变量的输出
    cout<<"Zbk:"<<endl;
    cout<<Zbk.title <<endl;
    cout<<Zbk.author<<endl;
    cout<<Zbk.pages<<endl;
    cout<<Zbk.price<<endl;
    cout<<"--------------------"<<endl;

    //对结构成员的运算
    Zbk.pages+=10;
    Zbk.price+=0.5;
    cout<<"Zbk.pages="<<Zbk.pages<<endl;
    cout<<"Zbk.price="<<Zbk.price<<endl;
    cout<<"--------------------"<<endl;

    //对结构变量的输入输出
    cout<<"Wbk.title =";
    cin>>Wbk.title;
    cout<<"Wbk.author=";
    cin>>Wbk.author;
    cout<<"Wbk.pages=";
    cin>>Wbk.pages;
    cout<<"Wbk.price=";
    cin>>Wbk.price;
    cout<<"Wbk:"<<endl;
    cout<<Wbk.title <<endl;
    cout<<Wbk.author<<endl;
    cout<<Wbk.pages<<endl;
    cout<<Wbk.price<<endl;
    cout<<"--------------------"<<endl;

    //结构变量之间的相互赋值
    books temp;
    temp=Wbk;
    cout<<"temp:"<<endl;
    cout<<temp.title<<endl;
    cout<<temp.author<<endl;
    cout<<temp.pages<<endl;
    cout<<temp.price<<endl;
    
    system("pause");
}

