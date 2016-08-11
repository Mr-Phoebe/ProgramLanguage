#include<iostream.h>
#include <process.h>
#include<stdio.h>
#include<conio.h>

void main(void)
{
    //变量声明
    char ch;
    FILE *fp1;

    //以写入方式打开d.dat文件 
    if ((fp1=fopen("d.dat","w"))==NULL)    {
       cout<<"\nCould not open the file."<<endl;
       cout<<"Exiting program."<<endl;
       exit(1);   //结束程序执行
    }

    //循环从键盘上读取字符,写入"流"文件
    cout<<"char:"<<endl;
    cin>>ch; 
    while (ch!='*') {
        fputc(ch,fp1);   //将字符写到fp1指向的"流"文件中
        cin>>ch; 
    }
    fclose(fp1);  //关闭文件

    // 以读方式打开d.dat文件
    if ((fp1=fopen("d.dat","r"))==NULL) 
    {
       cout<<"\nCould not open the file."<<endl;
       cout<<"Exiting program."<<endl;
       exit(1);   //结束程序执行
    }

    // 循环从"流"文件读取字符,并显示
    while ((ch=fgetc(fp1))!=EOF)  
          cout<<ch<<"  ";		
    cout<<endl;
    fclose(fp1); //关闭文件
}
