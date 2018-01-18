#include<iostream.h>
#include <process.h>
#include<stdio.h>
#include<conio.h>
void main(void) {
    //声明变量
    int i;
    char ch;
    FILE *fp1;

    //以写入方式打开d.dat文件 
    if ((fp1=fopen("d.dat","w"))==NULL)    {
       cout<<"\nCould not open the file."<<endl;
       cout<<"Exiting program."<<endl;
       exit(1);   //结束程序执行
    }

    //循环从键盘上读取字符,写入文件
    cout<<"char:";
    cin>>ch; 
    while (ch!='*') {
        fputc(ch,fp1);   //将字符写到fp1指向的"流"文件中
        cin>>ch; 
    }
    cout<<"--------------------"<<endl;
    fclose(fp1);  //关闭文件

    //以读方式打开d.dat文件
    if ((fp1=fopen("d.dat","r"))==NULL) 
    {
       cout<<"\nCould not open the file."<<endl;
       cout<<"Exiting program."<<endl;
       exit(1);   //结束程序执行
    }

    //循环从文件读取字符,并显示
    while ((ch=fgetc(fp1))!=EOF)  
          cout<<ch;		
    cout<<endl<<"--------------------"<<endl;

    //以下按倒序方式读取文件中的字符，并显示
    for (i=-1;;i--) {
        fseek(fp1,i,2);   			//设置文件指针，偏移量为i,相对文件尾
        if ((ch=fgetc(fp1))!=EOF)
            cout<<ch;
         else
            break;
    }
    cout<<endl<<"--------------------"<<endl;

    //以下读取"流"文件中偶数位置上的字符，并打印
    long position;
    for (i=0;;i=i+2) {
        fseek(fp1,i,0);        	//设置文件指针，偏移量为i,相对文件头
        position=ftell(fp1);
        if ((ch=fgetc(fp1))==EOF)	 //遇到文件尾，则退出，否则打印读取的字符
            break;     
        else {
           cout<<position<<" :"<<ch<<endl;
        }
    }
    cout<<endl;

    fclose(fp1); //关闭文件
}
