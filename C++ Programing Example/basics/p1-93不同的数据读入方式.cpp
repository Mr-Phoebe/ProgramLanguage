#include<iostream.h>
#include<stdio.h>
#include<process.h>
#include<stdlib.h>
#define MAX 5

//显示数组的数据
void show_array(double x[],int size) {
    for(int i=0;i<size;i++)
        cout<<x[i]<<" ";
    cout<<endl;
}

//main函数测试数组数据的文件读写
int main(void) 
{ 
    //声明变量
    FILE *fp;    // 声明FILE结构指针变量 
    int i;
    double a[MAX]={1.0,1.2,1.4,1.6,1.8};

    //显示数组a的数据
    cout<<"a:";
    show_array(a,MAX);

    //打开d.dat文件
    if ((fp=fopen("d.dat","wb+"))==NULL)
    {
       cout<<"\nCould not open the file."<<endl;
       cout<<"Exiting program."<<endl;
       exit(1);   //结束程序执行
    }

    //以单个元素对数组进行文件读操作
    for(i=0;i<MAX;i++) { 
        fwrite(&a[i], sizeof(double), 1, fp);
    }

    rewind(fp);   //恢复读写指针的位置

    //以单个元素对数组进行文件读操作
    double b[MAX];
    for(i=0;i<MAX;i++) { 
       if (!feof(fp))    //使用feof()判断文件尾 
         fread(&b[i], sizeof(double), 1, fp);
       else
            break;
    }
    cout<<"b:";
    show_array(b,MAX);//显示数组b的数据

    fclose(fp); // 关闭文件

    //打开d1.dat文件
    if ((fp=fopen("d1.dat","wb+"))==NULL)
    {
       cout<<"\nCould not open the file."<<endl;
       cout<<"Exiting program."<<endl;
       exit(1);   //结束程序执行
    }

    //将数组当成数据块写入文件
    fwrite(&a, sizeof(double), MAX, fp);

    rewind(fp);   //恢复读写指针的位置

    //将数组当成数据块从文件中读取
    double c[MAX];
    if (!feof(fp))    //使用feof()判断文件尾 
         fread(&c, sizeof(double),MAX,fp);
    cout<<"c:";
    show_array(c,MAX);  //显示数组c的数据
    
    fclose(fp); // 关闭文件
}
