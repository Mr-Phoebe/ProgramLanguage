/* 使用选择法排序 */
# include <stdio.h>

void main()
{
	int i, j, min, temp;
	/* 定义一个整型得一维数组 */
	int array[10];
	/* 输入数据 */
	printf("Please input ten integer: \n");
	for(i=0; i<10; i++)
	{
		printf("array[%d] = ", i);
		scanf("%d", &array[i]);
	}
	printf("The array is: ");
	for(i=0; i<10; i++)
		printf("%d ", array[i]);
	printf("\n");
	/* 排序 */
	for(i=0; i<9; i++)
	{
		min = i;
		for(j=i; j<10; j++)
			if(array[min]>array[j]) min = j;
		temp = array[i];
		array[i] = array[min];
		array[min] = temp;
	}
	/* 输出 */
	printf("\nThe result: \n");
	for(i=0; i<10; i++)
		printf("%d ", array[i]);
	printf("\n");
}