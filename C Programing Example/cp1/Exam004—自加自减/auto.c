# include <stdio.h>

void main()
{
	int i, j, k;
	int m, n, p;

	i = 8;
	j = 10;
	k = 12;
    
	/* 自增在操作数之前 */
	m = ++i;
    printf("i = %d\n", i);
	printf("m = %d\n", m);

	/* 自减在操作数之后 */
	n = j--;
	printf("j = %d\n", j);	
	printf("n = %d\n", n);

	/* 自增、自减的混合运算 */
	p = (++m)*(n++)+(--k);
	printf("k = %d\n", k);	
	printf("p = %d\n", p);	
}
