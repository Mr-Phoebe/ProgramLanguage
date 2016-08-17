'''
【程序77】
题目：填空练习（指向指针的指针）
1.程序分析：　　　　　
2.程序源代码：
main()
{ 
	char *s[]={"man","woman","girl","boy","sister"};
	char **q;
	int k;
	for(k=0;k<5;k++)
	{;/*ÕâÀïÌîÐ´Ê²Ã´Óï¾ä*/
	printf("%s\n",*q);
	}
} 
'''
if __name__ == '__main__':
    s = ["man","woman","girl","boy","sister"]
    for i in range(len(s)):
        print s[i]
        
