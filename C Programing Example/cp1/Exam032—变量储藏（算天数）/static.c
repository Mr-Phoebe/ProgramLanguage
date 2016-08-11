/* 给出年、月、日，计算该日是该年的第几天 */
# include <stdio.h>

int sum_day(int month, int day);
int leap(int year);

void main()
{
	int year, month, day;
	int days;
	printf("请输入日期(年，月，日)：");
	scanf("%d, %d, %d", &year, &month, &day);
	printf("%d年%d月%d日", year, month, day);
	days = sum_day(month, day);    /* 调用函数sum_day() */
	if(leap(year) && month>=3)    /* 调用函数leap() */
		days = days + 1;
	printf("是该年的第%d天.\n", days);
}

/* 定义静态存储变量并赋初值 */
static int day_tab[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

int sum_day(int month, int day)    /* 计算日期 */
{
	int i;
	for(i=1; i<month; i++)
		day = day + day_tab[i];
	return day;
}

int leap(int year)
{
	int leap;
	leap = (year%4==0&&year%100!=0)||(year%400==0);
	return leap;
}