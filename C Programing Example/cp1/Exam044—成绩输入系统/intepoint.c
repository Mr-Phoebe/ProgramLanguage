# include <stdio.h>

void avsco(float *psco, float *pave);
void avcour5(char *pcou, float *psco);
void fali2(char *pcou, int *pnum, float *psco, float *pave);
void excellence(char *pcou, int *pnum, float *psco, float *pave);

void main()
{
	/* 数组num用于存放每位学生的学号 */
	int i, j, *pnum, num[4];

    /* 数组aver用于存放每位学生的平均分，二维数组score用于存放学生成绩 */
	float score[4][5], aver[4], *psco, *pave;

	/* 数组course存放5门课程的名称 */
	char course[5][10], *pcou;  

	printf("请按行输入5门功课的名称：\n");
	pcou = course[0];  /* 指针变量pcou用来存放数组course的首地址(从首地址开始，每十个字节一个名称) */
	for(i=0; i<5; i++)
		scanf("%s", pcou+10*i);  /* 以空格为间隔输入五门课程的名称 */    

	printf("请按下面的格式输入4个学生的学号和各科成绩：\n");
	printf("学号");
	for(i=0; i<5; i++)
		printf(",%s", pcou+10*i);
	printf("\n");
	psco = &score[0][0];  /* 指针psco指向数组score中的第一个元素(指向第一个学生第一门课程的成绩) */
	pnum = &num[0];
	for(i=0; i<4; i++)
	{
		scanf("%d", pnum+i);  /* 输入学号 */
		for(j=0; j<5; j++)
			scanf(",%f", psco+5*i+j);  /* 以逗号为间隔输入学生成绩 */
	}

	pave = &aver[0];  /* 将数组aver的首地址赋给指针pave */
	printf("\n"); 

	avsco(psco, pave);
	avcour5(pcou, psco);
	printf("\n"); 

	fali2(pcou, pnum, psco, pave);
	printf("\n");  

	excellence(pcou, pnum, psco, pave);
}

void avsco(float *psco, float *pave)  /* 求每个学生的平均成绩 */
{
	int i, j;
	float sum, average;
	for(i=0; i<4; i++)  /* i代表学生的序号，表示第i个学生 */
	{
		sum = 0.0;
		for(j=0; j<5; j++)  /* j代表课程的序号，表示第j门课程 */
			sum = sum + (*(psco+5*i+j));  /* 累计每个学生的各科成绩 */
		average = sum/5;  /* 计算第i个学生平均成绩 */
		*(pave+i) = average;
	}
}

void avcour5(char *pcou, float *psco)  /* 求第五门课程的平均成绩 */
{
	int i;
	float sum, average5;
	sum = 0.0;
	for(i=0; i<4; i++)
		sum = sum + (*(psco+5*i+4));  /* 累计每个学生第五门课的得分 */
	average5 = sum/4;    /* 计算第五门课程的平均成绩 */
	printf("第5门课程%s的平均成绩为%5.2f.\n", pcou, average5);
}

void fali2(char *pcou, int *pnum, float *psco, float *pave)
{
	int i, j, k, label;
	printf("      =====两门以上课程不及格的学生=====     \n");
	printf("  学号  ");
	for(i=0; i<5; i++)
		printf(" %-8s", pcou+10*i);  /* 输出课程名称 */
	printf("  平均分\n");
	for(i=0; i<4; i++)
	{
		label = 0;
		for(j=0; j<5; j++)
			if(*(psco+5*i+j) < 60.0)
				label++;  /* 计算第i个学生不及格课程的门数 */
		if(label >= 2)
		{
			printf("%-8d", *(pnum+i));  /* 输出学号 */
			for(k=0; k<5; k++)
				printf("  %-8.2f", *(psco+5*i+k));  /* 输出符合条件学生的各科成绩 */
			printf("  %-8.2f\n", *(pave+i));  /* 输出符合条件学生的平均分 */
		}
	}
}


void excellence(char *pcou, int *pnum, float *psco, float *pave)    
{
	int i, j, k, label;
	printf("      =====成绩优秀学生=====\n");
	printf("  学号  ");
	for(i=0; i<5; i++)
		printf("  %-8s", pcou+10*i);
	printf("  平均分\n");
	for(i=0; i<4; i++)
	{
		label = 0;
		for(j=0; j<5; j++)
			if(*(psco+5*i+j) >= 85.0)
				label++;
		if((label>=5)||(*(pnum+i)>=90))
		{
			printf("%-8d", *(pnum+i));
			for(k=0; k<5; k++)
				printf("  %-8.2f", *(psco+5*i+k));
			printf("  %-8.2f\n", *(pave+i));
		}
	}
}
