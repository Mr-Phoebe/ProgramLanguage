'''
【程序62】
题目：学习putpixel画点。
1.程序分析：　　　　　　　　　　　　
2.程序源代码： 
#include "stdio.h"
#include "graphics.h"
main()
{
	int i,j,driver=VGA,mode=VGAHI;
	initgraph(&driver,&mode,"");
	setbkcolor(YELLOW);
	for(i=50;i<=230;i+=20)
		for(j=50;j<=230;j++)
			putpixel(i,j,1);
		for(j=50;j<=230;j+=20)
			for(i=50;i<=230;i++)
				putpixel(i,j,1);
}
'''
