#include <iostream.h>
#include<string.h>
//定义双亲（parent）类
class parent
{
    char  f_name[20];
    char  m_name[20];
    char  tel[10];
public:
    // parent类的构造函数，其带有缺省值(系统默认值)
    parent(char *p1="",char *p2="",char *p3="")
	{
        strcpy(f_name,p1);
        strcpy(m_name,p2);
        strcpy(tel,p3);
    }
    //显示parent对象的数据
    show_parent(void)
	{    
        cout<<"The parent:"<<endl;
        cout<<"    father's name:"<<f_name<<endl;
        cout<<"    mother's name:"<<m_name<<endl;
        cout<<"    tel:"<<tel<<endl;
    }
};
//定义student类
class student {
    int       num;
    char      name[20];
    float     grade;
    parent    pt;      
public:
    // student类的构造函数
    student(int n,char *str,float g,class parent t) {
        num=n;
        strcpy(name,str);
        grade=g;
        pt=t;
    }
    //显示student对象的数据
    show_student(void) {
        cout<<"num:"<<num<<endl;
        cout<<"name:"<<name<<endl;
        cout<<"grade:"<<grade<<endl;
        pt.show_parent();
    }
};
//main()函数测试student类的对象
main(void)
{
    //创建双亲对象
    parent p1("ZhangHua","LiLan","83665215");

	//创建学生对象
    student st(10001,"ZhangHui",91.5,p1); 
	
    //显示学生信息
	cout<<"p1:"<<endl;
	p1.show_parent();

    //显示学生信息
	cout<<"st:"<<endl;
    st.show_student();
}
