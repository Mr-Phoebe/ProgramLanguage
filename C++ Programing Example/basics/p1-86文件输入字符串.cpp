#include<iostream.h>
#include<stdio.h>
#include<string.h>
#include<process.h>
main()  {
    //声明变量
    FILE *fp1;
    char str[80];

    //从键盘上任意输入一个字符串
    cout<<"Inupt a string:";
    cin.getline(str,80);

    //以写入方式打开d.dat文件
    if ((fp1=fopen("d.dat","w"))==NULL)
    {
       cout<<"\nCould not open the file."<<endl;
       cout<<"Exiting program."<<endl;
       exit(1);   //结束程序执行
    }

    // 写"流"文件 
    fputs(str,fp1);         
    fputs("\n",fp1); 

    fclose(fp1);               	//关闭文件

    // 以读方式打开d.dat文件
    if ((fp1=fopen("d.dat","r"))==NULL) 
    {
       cout<<"\nCould not open the file."<<endl;
       cout<<"Exiting program."<<endl;
       exit(1);   //结束程序执行
    }

    // 循环从"流"文件读取字符,并显示
    char ch;
    while ((ch=fgetc(fp1))!=EOF)  
          cout<<ch;		
    cout<<endl;
    fclose(fp1); //关闭文件

}
