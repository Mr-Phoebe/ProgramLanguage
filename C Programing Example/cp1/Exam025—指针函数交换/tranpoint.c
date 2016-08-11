# include <stdio.h>

void swap(int *x, int *y);

void main()
{
	int i, j;

	i = 12;
	j = 36;

	printf("i and j before swapping: %d %d\n", i, j);

	swap(&i, &j);    /* 传递变量i和j的地址 */

	printf("i and j after swapping: %d %d\n", i, j);
}

void swap(int *x, int *y)
{
 	int temp;
    
    temp = *x;    /* 存储变量x的值 */
    *x = *y;      /* 将y的值放入到x中 */
    *y = temp;    /* 将x的值放入到y中 */
}
