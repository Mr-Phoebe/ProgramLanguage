#include <iostream.h>  //包含iostream.h头文件
main()
{
    char c1='\a',TAB='\t';  
	
    //阵铃一声
    cout<<c1<<endl;

    //使用水平制表符
    cout<<1<<TAB<<2<<TAB<<3<<TAB<<4<<endl;

    //使用双引号
    cout<<"He said \"Thank you\"."<<endl;  

    //使用回车换行
    cout<<"abc\n"<<"def"<<'\n';
}

