# include <stdio.h>

void main()
{
	int array[16][16];
	int i, j, k, m, n;
	
	/* 变量初始化 */
	m = 1;
	while(m == 1)
	{
		printf("请输入n(0<n<=15)，n是奇数)\n");
		scanf("%d", &n);
		/* 判断n是否是大于0小于等于15的奇数 */
		if((n!=0) && (n<=15) && (n%2!=0))
		{
			printf("矩阵阶数是 %d\n", n);
			m = 0;
		}
	}
	/* 数组赋初值为0 */
	for(i=1; i<=n; i++)
		for(j=1; j<=n; j++)
			array[i][j] = 0;

	/* 建立魔方阵:⑴ 将1放在第一行中间一列；
	⑵ 从2开始直到n×n止各数依次按下列规则存放：按 45°方向行走，如向右上。每一个数存放的行比前一个数的行数减1，列数加1
	⑶ 如果行列范围超出矩阵范围，则回绕。
	⑷ 如果按上面规则确定的位置上已有数，或上一个数是第1行第n列时，
	则把下一个数放在上一个数的下面。 */
	j = n/2 + 1;
	array[1][j] = 1;
	for(k=2; k<=n*n; k++)
	{
		i = i - 1;
		j = j + 1;
		if((i<1) && (j>n))
		{
			i = i + 2;
			j = j - 1;
		}
		else
		{
			if(i < 1)
				i = n;
			if(j > n)
				j = 1;
		}
		if(array[i][j] == 0)
			array[i][j] = k;
		else
		{
			i = i + 2;
			j = j - 1;
			array[i][j] = k;
		}
	}

	/* 输出魔方阵 */
	for(i=1; i<=n; i++)
	{
		for(j=1; j<=n; j++)
			printf("%5d", array[i][j]);
		printf("\n");
	}
}