# include <stdio.h>

void main()
{
	/* 经过下面的定义后，默认有：blue=0 red=1 ... black=4 */
	enum color {blue, red, yellow, purple, black};
	enum color i, j, k, pri;
	int n, loop;
	n = 0;

	for(i=blue; i<=black; i++)  /* i代表第一次所取铅笔的颜色 */
		for(j=blue; j<=black; j++)  /* j代表第二次所取铅笔的颜色 */  
			if(i!=j)  /* 第一次和第二次所取铅笔颜色不同 */
			{
				for(k=blue; k<=black; k++)  /* k代表第三次所取铅笔的颜色 */
					if((k!=i)&&(k!=j))  /* 三次所取铅笔颜色各不相同 */
					{
						n++;  /* 能得到三种不同颜色铅笔的可能取法加1 */
						printf("%-6d", n);
						/* 将当前i、j、k所对应的颜色依次输出 */
						for(loop=1; loop<=3; loop++)
						{
							switch(loop)
							{
							case 1: pri = i;
							        break;
							case 2: pri = j;
							        break;
							case 3: pri = k;
							        break;
							default:
								    break;
							}
							switch(pri)
							{
							case blue:   printf("%-10s", "blue");
									     break;
							case red:    printf("%-10s", "red");
									     break;
							case yellow: printf("%-10s", "yellow");
								         break;
							case purple: printf("%-10s", "purple");
								         break;
							case black:  printf("%-10s", "black");
									     break;
							default:
									     break;
							}
						}
						printf("\n");
					}
			}
			printf("total: %5d\n", n);
}