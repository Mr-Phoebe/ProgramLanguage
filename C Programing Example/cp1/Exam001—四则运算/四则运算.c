# include <stdio.h>

void main()
{
	/* 定义变量并赋初值 */
 	int    a = 5;       
	char   c = 'a';   
	float  f = 5.3;     
	double m = 12.65; 
    double result;
	
	/* 同类型数据间进行运算并输出结果 */
	printf("a + c = %d\n", a + c);
	printf("a + c = %c\n", a + c);
	printf("f + m = %f\n", f + m);

	/* 不同类型数据间进行运算并输出结果 */
	printf("a + m = %f\n", a + m);
	printf("c + f = %f\n", c + f);

	/* 将上述四个变量进行混合运算，并输出结果 */
	result = a + c * (f + m);
	printf("double = %f\n", result);
}


