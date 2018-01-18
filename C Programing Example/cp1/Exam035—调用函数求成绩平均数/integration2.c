/* 学生成绩统计 */
# include <stdio.h>
# define M 5
# define N 10

float score[N][M];
float a_stu[N], a_cor[M];

/* 声明子函数 */
void input_stu();
void avr_stu();
void avr_cor();
float highest(int *r, int *c);
float s_diff();

void main()    /* 主函数 */
{
	int i, j, r, c;
	float h;

	r = 0;
	c = 1;

	input_stu();    /* 调用函数input_stu,输入学生各门功课的成绩 */    
	avr_stu();    /* 调用函数avr_stu,求出每个学生的平均分 */
	avr_cor();    /* 调用函数avr_cor,找出学生成绩中的最高分*/

	printf("\n  序号   课程1   课程2   课程3   课程4   课程5   平均分");
	for(i=0; i<N; i++)
	{
		printf("\n  NO%2d", i+1);
		for(j=0; j<M; j++)
			printf("%8.2f", score[i][j]);
		printf("%8.2f", a_stu[i]);
	}

	printf("\n课平均");
	for(j=0; j<M; j++)
		printf("%8.2f", a_cor[j]);

	h = highest(&r, &c);
	printf("\n\n最高分%8.2f是 %d号学生的第%d门课\n", h, r, c);
	printf("  方差 %8.2f\n", s_diff());
}

void input_stu()    /* 输入学生的成绩 */
{
	int i, j;

	for(i=0; i<N; i++)
	{
		printf("请输入学生%2d的5个成绩:\n", i+1);
		for(j=0; j<M; j++)
			scanf("%f", &score[i][j]);
	}
}

void avr_stu()    /* 计算学生的平均分 */
{
	int i, j;
	float s;

	for(i=0; i<N; i++)
	{
		s = 0;
		for(j=0; j<M; j++)
			s = s + score[i][j];
		a_stu[i] = s/M;
	}
}

void avr_cor()    /* 计算课程的平均分 */
{
	int i, j;
	float s;

	for(j=0; j<M ;j++)
	{
		s = 0;
		for(i=0; i<N; i++)
			s = s + score[i][j];
		a_cor[j] = s/(float)N;
	}
}

float highest(int *r, int *c)    /* 找最高分 */
{
	float high;
	int i, j;

	high = score[0][0];
	for(i=0; i<N; i++)
		for(j=0; j<M; j++)
			if(score[i][j]>high)
			{
				high = score[i][j];
				*r = i + 1;
				*c = j + 1;
			}
	return high;
}

float s_diff()    /* 求方差 */
{
	int i;
	float sumx, sumxn;

	sumx = 0.0;
	sumxn = 0.0;

	for(i=0; i<N; i++)
	{
		sumx = sumx + a_stu[i]*a_stu[i];
		sumxn = sumxn + a_stu[i];
	}
	return (sumx/N-(sumxn/N)*(sumxn/N));
}