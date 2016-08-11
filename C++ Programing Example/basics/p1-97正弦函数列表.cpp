#include<iostream.h>
#include<math.h>   //此预处理指令不可少
const double HD=3.1415926/180;
main() {
    cout<<"x\tsin(x)"<<endl;
    for (int i=0;i<=180;i=i+30) 
        cout<<i<<"\t"<<sin(i*HD)<<endl;
}
