#include<iostream.h>
//定义结构
struct student {
    char  name[10];
    float   grade;
};

//交换student类型的数据 
void swap(student &x,student &y)      //swap的参数为引用传递方式
{
    student temp;
    temp=x;
    x=y;
    y=temp;
}

//返回student类型的引用，求优者 
student& max(student &x,student &y)      //swap的参数为引用传递方式
{
    return (x.grade>y.grade?x:y);
}

//显示student类型的数据 
void show(student &x)      //show的参数为引用传递方式
{
   cout<<x.name<<"  "<<x.grade<<endl;
}
void main()  
{
    student a={"ZhangHua",351.5},b={"WangJun",385};

    //显示a和b的数据
    cout<<"a:";
    show(a);
    cout<<"b:";
    show(b);
    cout<<"------------------"<<endl;

    //交换a和b的数据,并显示
    swap(a,b);    
    cout<<"a:";
show(a);
    cout<<"b:";
show(b);
    cout<<"------------------"<<endl;

    //计算和显示成绩高者
    student t=max(a,b);
    cout<<"Max:";
    show(t);
}
