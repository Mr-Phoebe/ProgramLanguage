#include<iostream.h>
#include<stdio.h>
#include<string.h>
#include<process.h>
main()  {
    //声明变量
    int i=0;
    char p[100];   			// 声明输入缓冲区 
    FILE *fp1;     			// 声明文件指针变量

    //以写入方式打开d.dat文件
    if ((fp1=fopen("d.dat","w"))==NULL)
    {
       cout<<"\nCould not open the file."<<endl;
       cout<<"Exiting program."<<endl;
       exit(1);   //结束程序执行
    }

    // 写文件操作 
    for (i=1;;i++)  {            //无条件循环
        cout<<i<<" string:";
        cin>>p;         	      //从键盘上输入数据
        if (stricmp(p,"end")) {	  //如果输入的字符串为end，则结束循环
            fputs(p,fp1);         //写入文件操作
            fputs("\n",fp1); 
        }
        else
            break;                //退出循环
    }
 
    fclose(fp1);               	//关闭文件

    // 以读方式打开d.dat文件
    if ((fp1=fopen("d.dat","r"))==NULL) 
    {
       cout<<"\nCould not open the file."<<endl;
       cout<<"Exiting program."<<endl;
       exit(1);   //结束程序执行
    }

    // 循环从文件读取字符,并显示
    while (fgets(p,100,fp1)!=NULL)  
          cout<<p;		
     fclose(fp1); //关闭文件
}
