/* 学生成绩查询系统 */
# include <stdio.h>
# include <stdlib.h>

void main( )
{
	int select;
	int i, j;
	int score[5][7];
	int average = 0;
	int sum = 0;
    do{
		printf("本程序有4项功能：\n");
		printf(" 1. 根据学号查询学生成绩\n");
		printf(" 2. 根据考试号统计成绩\n") ;
		printf(" 3. 根据考试号和学号查询成绩\n");
		printf(" 4. 成绩录入\n");
		printf(" 0. 退出\n");
		printf(" 请输入选择(0 - 4): ");
		scanf("%d", &select);
		switch(select)
		{
		case 0:
			printf("OK\n");
			exit(0);
			break;
		case 1:
			printf("输入学号：");
			scanf("%d\n", &i);
			for(j=1; j<7; j++)
			{
				printf("第%d科成绩是%d\n", j, score[i][j]);
				sum += score[i][j];
			}
			average = sum/6;
			printf("学生的平均成绩是%d\n", average);
			break;
		case 2:
			printf("输入考试号：");
			scanf("%d\n", &j);
			for(i=1; i<5; i++)
			{
				printf("第%d号学生本科成绩是%d\n", i, score[i][j]);
				sum += score[i][j];
			}
			average = sum/4;
			printf("本科平均成绩是%d\n", average);
			break;
		case 3:
			printf("输入学号和考试号：");
			scanf("%d %d\n", &i, &j);
			printf("第%d号学生的第%d科考试成绩是%d\n", i, j, score[i][j]);
			break;
		case 4:
			printf("请输入成绩\n");
			for(i=1; i<5; i++)
				for(j=1; j<7; j++)
					scanf("%d\n", &score[i][j]);
			break;
		default:
			break;
		}
	}while(1);
}