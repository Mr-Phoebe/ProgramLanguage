#include<iostream.h>
int extract_int()
{
    char ch;
    int n=0;
    while(ch=cin.get())
        if (ch>='0' && ch<='9')
        {
            cin.putback(ch);
            cin>>n;
            break;
        }
    return n;
}
//main()函数
main(void)
{
    //提取字符串中的数字
    int a=extract_int();
    int b=extract_int();
    int c=extract_int();
 
    //显示结果
    cout<<a<<"+"<<b<<"="<<c<<endl;
}
//cin.get()与getchar()相似，cin.get(字符指针，读取字符数)（可以接受空格，实际读取字符数会少一个，末尾为'\0'）
//cin.getline(字符指针，字符数，结束字符)（遇到结束字符的时候停止读取，默认为'\n'，实际字符数比字符数少1，末尾为'\0'）