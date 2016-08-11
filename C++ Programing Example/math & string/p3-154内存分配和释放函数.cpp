#include<iostream.h>
#include<stdlib.h>  
#include<malloc.h>
int main(void)
{
    //定义结构类型
    struct student {
       int num;
       char name[20];
       float grade;
    };

    //声明结构指针变量
    struct student *sp; 
    //计算申请的内存量
    int size=sizeof(struct student);

   //申请需要的存储空间并强制类型转换
   sp=(struct student*)malloc(size);

    //为结构对象输入数据
    cout<<"nmu:";
    cin>>(sp->num);
    cout<<"name:";
    cin>>(sp->name);
    cout<<"grade:";
    cin>>(sp->grade);

    //输出结构对象的数据
    cout<<"num:"<<(sp->num)<<endl;
    cout<<"name:"<<(sp->name)<<endl;
    cout<<"grade:"<<(sp->grade);
   
    //释放内存
    free(sp);
}
