# include <stdio.h>

void main()
{
	/* sex代表输血者的性别，weight代表输血者的体重，cubage代表输血量 */
	int sex, weight, cubage;
	printf("请给出输血者的性别和体重：");
	scanf("%d,%d", &sex, &weight);

	if(sex >= 0)    /* 若变量sex的数值为非负数，则表示为男性 */
	{
		if(weight >= 120)
		{
            cubage = 200;
			printf("此人应该输血：%d毫升\n", cubage);
		}
		else
		{
			cubage = 180;
			printf("此人应该输血：%d毫升\n", cubage);
		}
	}
	else   /* 否则，表示为女性 */
	{
		if(weight >= 100)
		{
            cubage = 150;
			printf("此人应该输血：%d毫升\n", cubage);
		}
		else
		{
			cubage = 120;
			printf("此人应该输血：%d毫升\n", cubage);
		}
	}
}