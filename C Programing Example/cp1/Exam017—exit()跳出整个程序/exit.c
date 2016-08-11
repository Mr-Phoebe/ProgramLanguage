# include <stdlib.h>
# include <stdio.h>

void main()
{
	int month;
	int day;
	
	printf("please input the month number: ");
	scanf("%d", &month);
	switch (month)
	{
	case 1:
	case 3:
	case 5:
	case 7:
	case 8:
	case 10:
	case 12: day=31;
			 break;
	case 4:
	case 6:
	case 9:
	case 11: day=30;
             break;
	case 2:  day=28;
             break;
	default: exit(0);
	}
	printf("1999.%d has %d days.\n", month, day);
}

