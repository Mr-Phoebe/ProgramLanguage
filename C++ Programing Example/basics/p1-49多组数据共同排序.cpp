#include<iostream.h>
main()
{
    // 声明用于存放运动员号码的数组
    int h[]={1001,1002,1003,1004}; 
    // 声明用于存放运动员成绩的数组
    float x[]={12.3,13.1,11.9,12.1};    
    //声明用于存放运动姓名的字符型指针数组
    char *p[]={"Wang hua","Zhang jian","Li wei","Hua ming"}; 
    //i,j,it是用做循环控制变量和临时变量
    int i,j,it; 
    //ft 用做暂存变量
    float ft;  
    //pt为字符型指针变量用做暂存指针变量
    char *pt; 

    //用选择法对数组x进行排序，并相应调整数组h和p中的数据
    for (i=0;i<=3;i++)  
        for (j=i+1;j<=3;j++)
           if (x[i]>=x[j]) {
              ft=x[i],x[i]=x[j],x[j]=ft;
              it=h[i],h[i]=h[j],h[j]=it;
              pt=p[i],p[i]=p[j],p[j]=pt;
           }

    //以下打印排序结果
    for (i=0;i<=3;i++)
       cout<<h[i]<<" ,"<<p[i]<<" ,"<<x[i]<<endl;
}
