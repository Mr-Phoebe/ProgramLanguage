#include<iostream.h>
main()
{
    int i;
    //定义结构类型 
    struct student {
           int  num;
           char  name[10];
           float maths;
           float physics;
           float chemistry;
           double  total;
    };

     //声明结构数组st
     student st[3];

     //从键盘上为结构数组输入值 
     cout<<"    num  name     maths physics chemistry "<<endl;
     for (i=0;i<3;i++)
     {
        cout<<i+1<<"   ";
        cin>>st[i].num;
        cin>>st[i].name;
        cin>>st[i].maths;
        cin>>st[i].physics;
        cin>>st[i].chemistry;
     }

    //计算每个学生的总成绩
    for (i=0;i<3;i++)
         st[i].total=st[i].maths+st[i].physics+st[i].chemistry;

    //输出结构数组各元素的值 
    for (i=0;i<3;i++)
    {
        cout<<"st["<<i<<"]:   ";
        cout<<st[i].num<<'\t';
        cout<<st[i].name<<'\t';
        cout<<st[i].maths<<'\t';
        cout<<st[i].physics<<'\t';
        cout<<st[i].chemistry<<'\t';
        cout<<st[i].total<<endl;
     }
}
