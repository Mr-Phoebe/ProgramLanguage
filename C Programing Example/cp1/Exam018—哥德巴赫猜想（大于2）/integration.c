# include <math.h>
# include <stdio.h>

void main( )
{
	int i, j, num;
	int p, q, flagp, flagq;
	printf("Please input a plus integer: ");
	scanf("%d", &num);

	/* 代码 (num%2)!=0) 表示num不能被2整除 */
	if(((num%2)!=0) || (num<=4))
		printf("input data error!\n");
	else
	{
		p = 1;
		/* do-while循环体 */
		do {
				p = p + 1;
				q = num - p;
				flagp = 1;
				flagq = 1;
				/* for循环体 */
				for(i=2; i<=(int)(floor(sqrt((double)(p)))); i++)
				{
					if((p%i) == 0)
					{
						flagp = 0;
						break;
					}
				}
				/* while循环体 */
				j = 2;
				while(j <= (int)(floor(sqrt((double)(q)))))
				{
					if ((q%j) == 0)
					{
						flagq = 0;
						break;
					}
					j++;
				}
			} while (flagp*flagq == 0);
		printf("%d = %d + %d \n", num, p, q);
	}
}