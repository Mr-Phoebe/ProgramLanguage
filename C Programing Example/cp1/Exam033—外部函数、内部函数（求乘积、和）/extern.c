# include <stdio.h>

void  main()
{
	/* 说明本文件将要使用其它文件中的函数 */
	extern int multiply();
	extern int sum();

    int a, b;
	int result;
	printf("Please input a and b: ");
	scanf("%d, %d", &a, &b);
	result = multiply(a, b);
	printf("The result of multiply is: %d", result);
	result = sum(a, b);
	printf("\nThe result of sum is: %d\n", result);

}