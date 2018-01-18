# include <stdio.h>

void main()
{
	int num;
	/* 下面定义的各变量，分别代表个位，十位，百位，千位，万位，十万位以及位数 */
	int indiv, ten, hundred, thousand; 
	int ten_thousand, hundred_thousand, place;

	printf("请输入一个整数(0～999999)：");
	scanf("%d", &num);

	/* 判断变量num的位数 */
	if(num > 99999)
		place = 6;
	else if(num > 9999)
		place = 5;
	else if(num > 999)
		place = 4;
	else if(num > 99)
		place = 3;
	else if(num > 9)
		place = 2;
	else
		place = 1;
	printf("place = %d\n", place);
	
	printf("每位数字为：");

	/* 求出num在各位上的值 */
	hundred_thousand = num/100000;
	ten_thousand = (num - hundred_thousand*100000)/10000;
	thousand = (num - hundred_thousand*100000 - ten_thousand*10000)/1000;
	hundred = (num - hundred_thousand*100000 - ten_thousand*10000 
		      - thousand*1000)/100;
	ten = (num - hundred_thousand*100000 - ten_thousand*10000 
		  - thousand*1000 - hundred*100)/10;
	indiv = num - hundred_thousand*100000 - ten_thousand*10000 
		    - thousand*1000 - hundred*100 - ten*10;

	/* 判断变量num的位数，并根据位数做出相应的输出 */
	switch(place)
	{
	case 1: printf("%d", indiv);
		    printf("\n反序数字为：");
			printf("%d\n", indiv);
			break;
    case 2: printf("%d, %d", ten, indiv);
		    printf("\n反序数字为：");
			printf("%d%d\n", indiv, ten);
			break;
	case 3: printf("%d, %d, %d", hundred, ten, indiv);
		    printf("\n反序数字为：");
			printf("%d%d%d\n", indiv, ten, hundred);
			break;
	case 4: printf("%d, %d, %d, %d", thousand, hundred, ten, indiv);
		    printf("\n反序数字为：");
			printf("%d%d%d%d\n", indiv, ten, hundred, thousand);
			break;
	case 5: printf("%d, %d, %d, %d, %d", ten_thousand, thousand, 
				   hundred, ten, indiv);
		    printf("\n反序数字为：");
			printf("%d%d%d%d%d\n", indiv, ten, hundred, 
				    thousand, ten_thousand);
			break;
	case 6: printf("%d, %d, %d, %d, %d, %d", hundred_thousand, 
				   ten_thousand, thousand, hundred, ten, indiv);
		    printf("\n反序数字为：");
			printf("%d%d%d%d%d%d\n", indiv, ten, hundred, thousand,
				    ten_thousand, hundred_thousand);
			break;
	default: printf("Not find.\n");
		     break;
	}
}