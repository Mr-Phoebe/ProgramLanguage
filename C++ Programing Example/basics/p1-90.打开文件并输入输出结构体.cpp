#include<iostream.h>
#include<stdio.h>
#include<string.h>
#include<process.h>
#include<stdlib.h>
#define MAX    3
main()  {
    //定义结构类型
    struct student {
        int num;
        char name[10];
        float grade;
    };

    //声明数组和变量
    student st[3];
    int i;
    FILE *fp1;     			    // 声明文件指针变量

    //以写入方式打开d.dat文件
    if ((fp1=fopen("d.dat","w"))==NULL)
    {
       cout<<"\nCould not open the file."<<endl;
       cout<<"Exiting program."<<endl;
       exit(1);   //结束程序执行
    }

    //从键盘上读数据,写入文件
    cout<<"    num    name    grade"<<endl;
    for (i=0;i<MAX;i++)  {     
        cout<<i+1<<" ";
        cin>>st[i].num;
        cin>>st[i].name;
        cin>>st[i].grade;
        fprintf(fp1,"%d %s %f\n",st[i].num,st[i].name,st[i].grade);
    }
 
    fclose(fp1);               	//关闭文件

    // 以读方式打开d.dat文件
    if ((fp1=fopen("d.dat","r"))==NULL) 
    {
       cout<<"\nCould not open the file."<<endl;
       cout<<"Exiting program."<<endl;
       exit(1);   //结束程序执行
    }
  
    // 循环从"流"文件读取字符,并显示
    student t;
    while ((fscanf(fp1, "%d %s %f",&t.num,t.name,&t.grade))!=EOF)  {
          cout<<t.num<<" ";		
          cout<<t.name<<" ";		
          cout<<t.grade<<endl;		
    }

    fclose(fp1); //关闭文件
}
