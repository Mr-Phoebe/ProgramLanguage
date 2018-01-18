# include <stdlib.h>
# include <stdio.h>

int main()
{
	char num1[80], num2[80];
	double sum1;
	int sum2;
	long sum3;

	printf("Enter first: ");
	gets(num1);
	printf("Enter second: ");
	gets(num2);
	sum1 = atof(num1)+atof(num2);
	printf("The sum is: %f\n", sum1);

	printf("Enter three: ");
	gets(num1);
	printf("Enter four: ");
	gets(num2);
	sum2 = atoi(num1)+atoi(num2);
	printf("The sum is: %d\n", sum2);

	printf("Enter five: ");
	gets(num1);
	printf("Enter six: ");
	gets(num2);
	sum3 = atol(num1)+atol(num2);
	printf("The sum is: %ld\n", sum3);

	return 0;
}