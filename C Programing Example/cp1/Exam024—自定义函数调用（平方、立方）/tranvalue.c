# include <stdio.h>

/* ×Óº¯ÊıÉùÃ÷ */
int square(int x);
int cube(int y);

void main()
{
	int m = 12;
	int n = 4;
	printf("%d %d\n", square(m), m);
	printf("%d %d\n", cube(n), n);
}

int square(int x)
{
	x = x*x;
	return x;
}

int cube(int y)
{
	y = y*y*y;
	return y;
}