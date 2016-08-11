# include <stdio.h>

void inv(int *x, int n);

void main()
{
	int i;
	int array[10] = {1, 3, 9, 11, 0, 8, 5, 6, 14, 98};
	printf("原始数组是:\n");
	for(i=0; i<10; i++)
		printf("%d " , array[i]);
	printf("\n");
	inv(array, 10);
	printf("按相反次序存放后的数组为:\n");
	for(i=0; i<10; i++)
		printf("%d ", array[i]);
	printf("\n");
}

void inv(int *x, int n)
{
	int *p, *i, *j;
	int t;
	int m = (n-1)/2;
	i = x; 
	j = x + n - 1;
	p = x + m;
	for(; i<=p; i++, j--)
	{
		t = *i;
		*i = *j;
		*j = t;
	}
}