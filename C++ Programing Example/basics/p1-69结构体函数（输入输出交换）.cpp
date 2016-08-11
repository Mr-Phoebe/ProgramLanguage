#include<iostream.h>

//定义公共结构类型
struct student {
       int  num;
       char  name[10];
       float maths;
       float physics;
       float chemistry;
       double  total;
};
 
//定义结构输入函数
input_Rec(struct student *p)   //参数为student类型的结构指针变量
{
    cin>>p->num;
    cin>>p->name;
    cin>>p->maths;
    cin>>p->physics;
    cin>>p->chemistry;
}

//定义结构数据交换函数
swap_Rec(struct student *p1,struct student *p2)
{
    struct student x;

    //交换两个记录的数据
    x=*p1;
    *p1=*p2;
    *p2=x;
}

//输出结构的值
put_Rec(struct student *p)
{
    cout<<p->num<<'\t';
    cout<<p->name<<'\t';
    cout<<p->maths<<'\t';
    cout<<p->physics<<'\t';
    cout<<p->chemistry<<'\t';
    cout<<p->total<<endl;
}

//定义main()函数
main() 
{
    int i,j;
    // 声明结构指针变量和结构数组 
    struct student *p1,a[3];  

    //输入3个学生的数据并计算总成绩
    cout<<"num\tname\tmaths\tphysics\tchemistry"<<endl;
    for (p1=a;p1<=a+2;p1++)  {
         input_Rec(p1);
         p1->total=p1->maths+p1->physics+p1->chemistry;
    }

    //对3个学生的数据排序
    for (i=0;i<=2;i++)  
         for (j=i+1;j<=2;j++)
             if (a[i].total<a[j].total)
                 swap_Rec(&a[i],&a[j]);   //交换两个结构变量中的数据
     cout<<"-------------------"<<endl;	  //输出一分界线

     //输出排序后的结构数组
    cout<<"num\tname\tmaths\tphysics\tchemistry\ttotal"<<endl;
    for (p1=a;p1<=a+2;p1++)
          put_Rec(p1);
}
