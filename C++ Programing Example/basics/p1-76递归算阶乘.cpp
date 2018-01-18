#include<iostream.h>
main()  
{
    //函数原型声明
    int fact(int x);
    int n,sn;

    //依次从键盘上输入3个正整型数据计算它们的阶乘
    for (int i=1;i<=3;i++)
    {
        cout<<i<<"   n=";
        cin>>n;
        sn=fact(n);
        cout<<n<<"!="<<sn<<endl;
    }
}

//以下是采用递归方法定义的fact()函数
int fact(int x)
{
   if (x==0) return(1);
      return(x*fact(x-1));  //此处又调用了它自身
}
