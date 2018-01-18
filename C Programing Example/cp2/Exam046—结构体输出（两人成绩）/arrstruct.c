/* 输入学生成绩并显示 */
# include <stdio.h>

struct student
{
	char number[6];
	char name[6];
	int  score[3];
} stu[2];

void output(struct student stu[2]);

void main()
{
	int i, j;
	for(i=0; i<2; i++)
	{
		printf("请输入学生%d的成绩：\n", i+1);
		printf("学号：");
		scanf("%s", stu[i].number);
		printf("姓名：");
		scanf("%s", stu[i].name);
		for(j=0; j<3; j++)
		{
			printf("成绩 %d.  ", j+1);
			scanf("%d", &stu[i].score[j]);
		}
		printf("\n");
	}
	output(stu);
}

void output(struct student stu[2])
{
	int i, j;
	printf("学号  姓名  成绩1  成绩2  成绩3\n");
    for(i=0; i<2; i++)
	{
		printf("%-6s%-6s", stu[i].number, stu[i].name);
		for(j=0; j<3; j++)
			printf("%-8d", stu[i].score[j]);
		printf("\n");
	}
}