# include <stdio.h>
# include <stdlib.h>
# include <time.h>

/* 利用系统时间来寻找随机数，并将前十个随机数显示出来 */
int main()
{
	long time1;
	int i, time2;
	

	/* 获得正确的日历时间 */
	time1 = time(NULL);    /* 返回系统的当前日历时间 */

	printf("%ld\n", time1);

	time2 = (unsigned)time1/2;
	printf("%ld\n", time2);

	/* 以系统时间为参数，为即将生成的伪随机数序列设置起点 */
	srand(time2);

	/* 生成十个伪随机数序列 */
	for(i=0; i<10; i++)
		printf("%d ", rand());
	printf("\n");

	return 0;
}