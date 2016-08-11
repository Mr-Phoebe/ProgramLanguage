#include <iostream.h>
main()
{
    int n;
    cout<<"n=";
    cin>>n;
    if (n>=0 && n<=100 &&n%2==0)
       cout<<"n="<<n<<endl;
    else
       cout<<"The "<<n<<" is out of range!"<<endl;
}

