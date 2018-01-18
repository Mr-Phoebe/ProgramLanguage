#include <iostream.h>
//定义空类empty
class empty
{
};
//在main()函数中用空类创建对象
main()
{
    empty a,*p;  //编译通过
    cout<<"Test a empty class."<<endl;
}
