#include<stdio.h>
#include<stdlib.h>
#include<iostream.h>
int main(void) 
{ 
    //声明变量
    char ch;
    char str[20];
    int n;
    float x;

    //用stdin从键盘上输入数据
    fprintf(stdout,"ch str\n");
    fscanf(stdin,"%c %s",&ch,str);
    fprintf(stdout,"n    x \n");
    fscanf(stdin,"%d  %f",&n,&x);
    cout<<"----------------"<<endl;

    //输出显示
    fprintf(stdout,"ch=%c str=%s",ch,str);
    fprintf(stdout,"\nn=%d x=%f",n,x);
    cout<<endl;
}
