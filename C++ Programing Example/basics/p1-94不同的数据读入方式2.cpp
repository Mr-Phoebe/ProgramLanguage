#include<iostream.h>
#include<stdio.h>
#include<process.h>
#include<stdlib.h>
#define MAX 5
//定义结构类型
struct student {
       int  num;
       char name[20];
       float grade;
};

//显示student结构数据
void show_str(student a,char *name) {
    cout<<name<<":"<<endl;
    cout<<a.num<<" "<<a.name<<" "<<a.grade;
    cout<<endl;
}

//main函数测试结构数据的文件读写
int main(void) 
{ 
    //声明变量
    FILE *fp;    
    //声明FILE结构指针变量 
    student st={1001,"ZhangBin",85.5};

    //显示st结构数据
    show_str(st,"st");

    //打开d.dat文件
    if ((fp=fopen("d.dat","wb+"))==NULL)
    {
       cout<<"\nCould not open the file."<<endl;
       cout<<"Exiting program."<<endl;
       exit(1);   //结束程序执行
    }

    //用fprintf()函数写结构数据到文件
    fprintf(fp,"%d %s %f",st.num,st.name,st.grade);

    rewind(fp);   //恢复读写指针的位置

    //用fscanf()函数读文件中的数据赋值给结构并显示
    student temp;
    fscanf(fp, "%d %s %f",&temp.num,temp.name,&temp.grade);
    show_str(temp,"temp");
    cout<<"-----------------------"<<endl;

    fclose(fp); // 关闭文件

    //将结构数据当成数据块进行读写
    if ((fp=fopen("d1.dat","wb+"))==NULL)  //打开d1.dat文件
    {
       cout<<"\nCould not open the file."<<endl;
       cout<<"Exiting program."<<endl;
       exit(1);   //结束程序执行
    }

    //声明结构数组并初始化
    int i;
    student starr[3]={{101,"WangPing",92},{102,"Li",85},{103,"LiuMin",97}};

    //显示结构数组
    for(i=0;i<3;i++) 
        show_str(starr[i],"starr");

    //将结构数组当成数据块写入文件
    fwrite(starr, sizeof(student), 3, fp);

    rewind(fp);   //恢复读写指针的位置

    //按数据块从文件中读取数据赋值给结构数组
    student temp_arr[3];
    if (!feof(fp))    //使用feof()判断文件尾 
         fread(temp_arr, sizeof(student),3,fp);
    for(i=0;i<3;i++) 
        show_str(temp_arr[i],"temp_arr");
    
    fclose(fp); // 关闭文件
}
