# include <stdio.h>

void main()
{
	/* 定义了一个无符号字符型变量，此变量只能用来存储无符号数 */
	unsigned char result;
    
	int a, b, c, d;
	a = 2;
	b = 4;
	c = 6;
	d = 8;

	/* 对变量进行“按位与”操作 */
	result = a & c;
	printf("result = %d\n", result);

	/* 对变量进行“按位或”操作 */
	result = b | d;
	printf("result = %d\n", result);

	/* 对变量进行“按位异或”操作 */
	result = a ^ d;
	printf("result = %d\n", result);

	/* 对变量进行“取反”操作 */
	result = ~a;
	printf("result = %d\n", result);
}