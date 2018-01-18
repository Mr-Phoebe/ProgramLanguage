#include <iostream.h>  //包含iostream.h头文件
main()
{
    //输入输出字符
    char c;
    cin>>c;
    cout<<"c="<<c<<endl;

    //输入输出整型数据
    int n;
    cin>>n;
    cout<<"n="<<n<<endl;

    //输入输出浮点型数据
    double x;
    cin>>x;
    cout<<"x="<<x<<endl; 

    //输入提示
    cout<<"n=";
    cin>>n;
    cout<<"n="<<n<<endl;

    //多项输入
    cout<<"c n x"<<endl;
    cin>>c>>n>>x;
    cout<<"c="<<c<<" n="<<n<<" x="<<x<<endl;
}
