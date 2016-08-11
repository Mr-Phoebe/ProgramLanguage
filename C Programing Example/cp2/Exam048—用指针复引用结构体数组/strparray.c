# include <stdio.h>

/* 定义一个全局的结构体 */
struct student
{
	long num;
	char name[20];
	char sex;
	int age;
};

/* 声明结构体数组并赋初值 */
struct student stu[4] = {{97032, "xiao ming", 'M', 20},
                         {97033, "xiao wang", 'M', 20},
						 {97034, "xiao tong", 'M', 21},
                         {97035, "xiao shui", 'F', 18}};

void main()
{
	/* 定义一个结构体指针变量 */
	struct student *p;

	printf(" 学号     姓名     性别     年龄\n");
	for(p=stu; p<stu+4; p++)
		printf("%-8ld%-12s%-10c%-3d\n", p->num, p->name, 
		                               p->sex, p->age);
}
