#include<iostream.h>
//定义结构类型
struct student
{
    int   num;
    char  name[20];
    float grade;
};
void main(void)
{
    //声明数组
    int i,size;
    char str[]="This is a string.";
    int int_values[] = {51, 23, 2, 44, 45,0,11}; 
    float float_values[] = {15.1, 13.3, 22.2, 10.4, 1.5};  
    student st_arr[]={101,"WangLin",92,102,"LiPing",85,103,"ZhaoMin",88};
		
    //显示char类型数组元素及其大小
    size=sizeof(str) / sizeof(char);
    cout<<"Number of elements in str: ";
    cout<<size<<endl;
    for(i=0;i<size;i++) {
        cout<<str[i];
    }
    cout<<endl;

    //显示int类型数组元素及其大小
    size=sizeof(int_values) / sizeof(int);
    cout<<"Number of elements in int_values: ";
    cout<<size<<endl;
    for(i=0;i<size;i++) {
        cout<<int_values[i]<<" ";
    }
    cout<<endl;

    //显示float类型数组元素及其大小
    size=sizeof(float_values) / sizeof(float);
    cout<<"Number of elements in float_values: ";
    cout<<size<<endl;
    for(i=0;i<size;i++) {
        cout<<float_values[i]<<" ";
    }
    cout<<endl;

    //显示student类型数组元素及其大小
    size=sizeof(st_arr) / sizeof(student);
    cout<<"Number of elements in st_arr: ";
    cout<<size<<endl;
    for(i=0;i<size;i++) {
        cout<<st_arr[i].num<<" ";
        cout<<st_arr[i].name<<" ";
        cout<<st_arr[i].grade<<endl;
    }
}
