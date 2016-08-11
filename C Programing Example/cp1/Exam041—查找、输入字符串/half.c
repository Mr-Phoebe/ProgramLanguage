# include <stdlib.h>
# include <string.h>
# include <stdio.h>

void main()
{
	/* 声明子函数 */
	int binary(char *ptr[], char *str, int n);    /* 查找函数声明 */
	void insert(char *ptr[], char *str, int n, int i);    /* 插入函数声明 */

	char *temp, *ptr1[6];
	int i;
	printf("请为字符形指针数组赋初值：\n");
	for (i=0; i<5; i++)
	{
		ptr1[i] = (char *)malloc(20);    /* 为指针分配地址后 */
		gets(ptr1[i]);    /* 输入字符串 */
	}
	ptr1[5] = (char *)malloc(20);
	printf("\n");

	printf("original string:\n");
	for(i=0; i<5; i++)    /* 输出指针数组各字符串 */
		printf("%s\n", ptr1[i]);

	printf("\ninput search string:\n");
	temp = (char *)malloc(20);
	gets(temp);    /* 输入被插字符串 */

	i=binary(ptr1, temp, 5);    /* 寻找插入位置i */
	printf("i = %d\n", i);

    insert(ptr1, temp, 5, i);    /* 在插入位置i处插入字符串 */
	printf("output strings:\n");

	for(i=0; i<6; i++)    /* 输出指针数组的全部字符串 */
		printf("%s\n", ptr1[i]);
}

int binary(char *ptr[], char *str, int n)
{ 
	/* 折半查找插入位置 */
	int hig, low, mid;
	low = 0;
	hig = n-1;
	if(strcmp(str,ptr[0]) < 0) 
		return 0;
    /* 若插入字符串比字符串数组的第0个小，则插入位置为0 */
	if(strcmp(str,ptr[hig]) > 0) 
		return n;
    /* 若插入字符串比字符串数组的最后一个大，则应插入字符串数组的尾部 */
    while(low <= hig)
	{
		mid = (low + hig)/2 ;
		if (strcmp(str,ptr[mid]) < 0)
			hig = mid - 1;
		else if(strcmp(str,ptr[mid]) > 0)
			low = mid + 1;
		else 
			return mid;    /* 插入字符串与字符串数组的某个字符串相同 */
	}
	return low;    /* 插入的位置在字符串数组中间 */
}

void insert(char *ptr[], char *str, int n, int i)
{
	int j;
	for(j=n; j>i; j--)    /* 将插入位置之后的字符串后移 */
		strcpy(ptr[j], ptr[j-1]);
	strcpy(ptr[i], str);    /* 将被插字符串按字典顺序插入字符串数组 */
}