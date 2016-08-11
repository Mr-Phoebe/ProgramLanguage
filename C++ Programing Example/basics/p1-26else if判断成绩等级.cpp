#include <iostream.h>
main()
{
    int score;

    //从键盘上输入分数
    cout<<"score=";
    cin>>score;

    //用带else if的条件语句判断处理
    if (score<0 || score>100)    
    {
       cout<<"The score is out of range!"<<endl;
    }
    else if (score>=90) 
       cout<<"Your grade is a A."<<endl;
    else if (score>=80) 
       cout<<"Your grade is a B."<<endl;
    else if (score>=70) 
       cout<<"Your grade is a C."<<endl;
    else if (score>=60) 
       cout<<"Your grade is a D."<<endl;
    else 
       cout<<"Your grade is a E."<<endl;
}
