#include<iostream.h>
#include <process.h>
#include <stdlib.h> 
#include <stdio.h> 
int main(void) 
{ 
    FILE *fpd,*fpw;    // 声明FILE结构指针变量 
    unsigned char dw;
    int i=0;

    //以二进制读方式打开Calc.exe文件
    if((fpd=fopen("C:\WINDOWS\Calc.exe", "rb"))==NULL) 
    { 
       cout<<"\nCould not open the file."<<endl;
       cout<<"Exiting program."<<endl;
       exit(1);   //结束程序执行
    } 

    // 以二进制写方式打开test.exe文件 
    if((fpw=fopen("test.exe", "wb+"))==NULL)
    {
       cout<<"\nCould not open the file."<<endl;
       cout<<"Exiting program."<<endl;
       exit(1);   //结束程序执行
    }

    // 二进制文件读写操作，每次指定读写1个字节
    while(!feof(fpd)) {   //使用feof()判断文件尾 
        fread(&dw, 1, 1, fpd);
        fwrite(&dw, 1, 1, fpw);
    }
    // 关闭文件
    fclose(fpd);
    fclose(fpw);

    //执行Calc.exe和Calc.exe文件
    cout<<"1 Run C:\WINDOWS\Calc.exe"<<endl;
    system("C:\WINDOWS\Calc.exe");
    cout<<"-------------------"<<endl;
    cout<<"2 Run test.exe!"<<endl;
    system("test.exe");
}
