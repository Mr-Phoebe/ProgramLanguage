#include<iostream.h>
#include<stdio.h>
#include<string.h>
#include<process.h>
#include<stdlib.h>
#define MAX    10
main()  {
    //声明变量
    int i,n;
    FILE *fp1;     			// 声明文件指针变量

    //以写入方式打开d.dat文件
    if ((fp1=fopen("d.dat","w"))==NULL)
    {
       cout<<"\nCould not open the file."<<endl;
       cout<<"Exiting program."<<endl;
       exit(1);   //结束程序执行
    }

    // 写文件操作 
    for (i=1;i<=MAX;i++)  {     
        n=rand();        //产生1个整数随机数
        putw(n,fp1);
        cout<<n<<" ";
    }
    cout<<endl<<"--------------------"<<endl;
 
    fclose(fp1);               	//关闭文件

    // 以读方式打开d.dat文件
    if ((fp1=fopen("d.dat","r"))==NULL) 
    {
       cout<<"\nCould not open the file."<<endl;
       cout<<"Exiting program."<<endl;
       exit(1);   //结束程序执行
    }
  
    // 循环从"流"文件读取字符,并显示
    while ((n=getw(fp1))!=EOF)  
          cout<<n<<" ";		

    fclose(fp1); //关闭文件
}
