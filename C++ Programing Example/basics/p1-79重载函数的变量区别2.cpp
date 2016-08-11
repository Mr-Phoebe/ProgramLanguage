#include<iostream.h>
//定义结构
struct student {
    char  name[10];
    float   grade;
};

//更改student数据的grade成员,参数形式为引用 
void change(student &x,float grade) 
{
    x.grade=grade;
}

//更改student数据的grade成员,参数形式为指针 
void change1(student *p,float grade)      
{
    p->grade=grade;
}

//更改student类型的数据,普通参数形式 
void change2(student x,float grade)      
{
    x.grade=grade;
}

//显示student类型的数据,参数形式为引用
void show(student &x)      
{
    cout<<x.name<<"  "<<x.grade<<endl;
}

//在main()函数中，测试对结构的处理函数
void main()  
{
    student a={"ZhangHua",351.5};

    //显示a的数据
    show(a);

    //用change修改分数,并显示
	cout<<"change(student &x,float grade):"<<endl;
    change(a,360);
    show(a);

    //用change1修改分数,并显示
	cout<<"change1(student *p,float grade):"<<endl;
    change1(&a,375);
    show(a);

    //用change2修改分数,并显示
	cout<<"change2(student x,float grade):"<<endl;
    change2(a,380.5);
    show(a);
}
