# include <stdio.h>

void main( )
{
	int radius;
	double area;
	for(radius = 1; radius <= 10 ; radius++)
	{
		area = 3.1416 * radius * radius;
		/* 若圆面积超过120，则跳出for循环，不予输出 */
		if(area >= 120.0)
			break;
		printf("square = %f\n", area);
	}
	printf("now radius=%d\n\n", radius-1);

	for(radius = 1; radius <= 10 ; radius++)
	{
		area = 3.1416 * radius * radius;
		/* 若圆面积没有超过60，则不输出而是从新开始循环 */
		if(area < 120.0)
			continue;
		printf("square = %f\n", area);
	}
	printf("now radius=%d\n", radius-1);
}