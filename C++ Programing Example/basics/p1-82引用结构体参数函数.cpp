#include<iostream.h>
#include<stdio.h>
#define size 3
//定义book结构类型
struct book
{
    char   title[20];
    char   author[15];
    int    pages;
    float  price;
};
//book结构的输入函数
input_book(book& bk,char *name)
{
    cout<<name<<":"<<endl;
    cout<<"title:";
    cin>>bk.title;
    cout<<"author:";
    cin>>bk.author;
    cout<<"pages:";
    cin>>bk.pages;
    cout<<"price:";
    cin>>bk.price;
}
//book结构的输出函数
output_book(book& bk,char *name)
{
    cout<<name<<":  ";
    cout<<bk.title<<" ";
    cout<<bk.author<<" ";
    cout<<bk.pages<<" ";
    cout<<bk.price<<endl;
}
void main(void)
{
    //声明变量和结构数组
    int i;
    char str[20];
    book bk[size];

    //输入结构数组
    for(i=0;i<size;i++) {
        sprintf(str,"bk[%d]",i+1);
        input_book(bk[i],str);
    }

    //显示结构数组
    for(i=0;i<size;i++) {
        sprintf(str,"bk[%d]",i+1);
        output_book(bk[i],str);
    }
}
