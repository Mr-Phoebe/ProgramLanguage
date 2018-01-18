#include <iostream.h>
main()
{
    int a,b,c;
    int smallest;
    cout<<"a  b  c"<<endl;
    cin>>a>>b>>c;
    if (a<=b)    //外层条件语句
    {
        if (a<=c)    //内层条件语句
           smallest=a;
        else
           smallest=c;
    }
    else
    {
       if (b<=c)    //内层条件语句
           smallest=b;
       else
           smallest=c;
    }
    cout<<"Smallest="<<smallest<<endl;
}

