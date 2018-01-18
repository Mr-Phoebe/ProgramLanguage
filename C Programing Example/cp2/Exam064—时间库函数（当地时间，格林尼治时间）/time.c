# include <time.h>
# include <stdio.h>

int main()
{
	struct tm *local;
	time_t tm;

	tm = time(NULL);//系统当前日历时间
	local = localtime(&tm);//分解形式的TIME形式
	printf("Local time and date: %s\n", asctime(local));//格式化时间串

	local = gmtime(&tm);//返回一个格林尼治时间
	printf("UTC time and date: %s\n", asctime(local));

	return 0;
}