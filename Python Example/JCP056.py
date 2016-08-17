'''
【程序56】
题目：画图，学用circle画圆形。　　　
1.程序分析：
2.程序源代码：
#include "graphics.h"
main()
{
	int driver,mode,i;
	float j=1,k=1;
	driver=VGA;mode=VGAHI;
	initgraph(&driver,&mode,"");
	setbkcolor(YELLOW);
	for(i=0;i<=25;i++)
	{
		setcolor(8);
		circle(310,250,k);
		k=k+j;
		j=j+0.3;
	}
}

'''
if __name__ == '__main__':
    from Tkinter import *

    canvas = Canvas(width=800, height=600, bg='yellow')  
    canvas.pack(expand=YES, fill=BOTH)                
    k = 1
    j = 1
    for i in range(0,26):
        canvas.create_oval(310 - k,250 - k,310 + k,250 + k, width=1)
        k += j
        j += 0.3

    mainloop()
