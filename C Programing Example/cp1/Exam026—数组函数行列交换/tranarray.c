/* 矩阵的转置 */
# include <stdio.h>
# define N 3

/* 转置函数声明 */
void convert(int element[N][N]);

void main()
{
	/* 定义一个二维数组 */
	int array[N][N];

	int i, j;
	/* 给数组符初值 */
	printf("输入数组元素：\n");
	for(i=0; i<N; i++)
		for(j=0; j<N; j++)
			scanf("%d", &array[i][j]);
	printf("\n数组是：\n");
	for(i=0; i<N; i++)
	{
		for(j=0; j<N; j++)
			printf("%5d", array[i][j]);
		printf("\n");
	}

	/* 对数组进行转置工作 */
	convert(array);
	printf("转置数组是：\n");
	for(i=0; i<N; i++)
	{
		for(j=0; j<N; j++)
			printf("%5d", array[i][j]);
		printf("\n");
	}
}

/* 转置函数定义 */
void convert(int element[N][N])
{
	int i, j, t;
	for(i=0; i<N; i++)
		for(j=i+1; j<N; j++)
		{
			t = element[i][j];
			element[i][j] = element[j][i];
			element[j][i] = t;
		}
}

