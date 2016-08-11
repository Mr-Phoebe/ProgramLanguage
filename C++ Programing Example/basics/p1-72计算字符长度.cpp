#include <iostream.h>
//计算字符串长度的函数
int str_len(const char *string)
{
    //char *temp=string; 编译报错！
    //*string='x';       编译报错！
    int i=0;
    while (*(string+i)!=NULL) 
        i++;
    return i;
}

//main()函数中测试str_len()
void main()
{
    char a[]="ABCDE";
    cout<<a<<"\t"<<str_len(a)<<endl;
    char *str="Hello!";
    cout<<str<<"\t"<<str_len(str)<<endl;
    cout<<"This is a test."<<"\t"<<str_len("This is a test.")<<endl;
}
