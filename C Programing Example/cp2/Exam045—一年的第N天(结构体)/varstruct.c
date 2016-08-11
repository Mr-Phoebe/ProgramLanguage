/* 计算天数 */
# include <stdio.h>

struct 
{
	int year;
	int month;
	int day;
} data;    /* 定义一个结构并声明对象为data */

void main()
{
	int days;
	printf("请输入日期(年、月、日)：");
	scanf("%d, %d, %d", &data.year, &data.month, &data.day);
	switch(data.month)
	{
	case 1:  days = data.day;    
		     break;
	case 2:  days = data.day+31;
		     break;
	case 3:  days = data.day+59;
		     break;
	case 4:  days = data.day+90;
		     break;
	case 5:  days = data.day+120;
		     break;
	case 6:  days = data.day+151;
		     break;
	case 7:  days = data.day+181;
		     break;
	case 8:  days = data.day+212;
		     break;
	case 9:  days = data.day+243;
		     break;
	case 10: days = data.day+273;
		     break;
	case 11: days = data.day+304;
		     break;
	case 12: days = data.day+334;
		     break;
	}
	if(data.year%4==0&&data.year%100!=0 || data.year%400==0)
		if(data.month>=3)
			days = days + 1;
	printf("%d月%d日是%d年的第%d天.\n", data.month, data.day, data.year, days);
}
