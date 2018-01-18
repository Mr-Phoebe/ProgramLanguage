# include <stdio.h>
# include <string.h>

void main()
{
	struct student
	{
		long num;
		char name[30];
		char sex[10];
		float score;
	};
	struct student stu;
	struct student *p;
	p = &stu;
	stu.num = 97032;
	strcpy(stu.name, "小明");
	strcpy(stu.sex, "男");
	stu.score = 98.5;

	printf("学号: %ld\n姓名: %s\n性别: %s\n分数: %4.2f\n",
		    stu.num, stu.name, stu.sex, stu.score);
	printf("\n");
	printf("学号: %ld\n姓名: %s\n性别: %s\n分数: %4.2f\n",
		    (*p).num, (*p).name, (*p).sex, (*p).score);
}