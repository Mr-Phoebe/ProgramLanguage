#include <stdio.h>
#include <stdlib.h> 
#include <string.h>
#define NUM 4

struct Data
{
	char name[20];
	char city[20];
	char sex[10];
	char age[10];
	char job[10];
};

struct Data SDatas[NUM]=
{
	"Sun","Weifang","Male","24","student",
	"Tom","Beijing","Male","31","doctor",
	"Marry","Shanghai","Female","19","techer",
	"Willing","Tianjing","Female","21","worker"
};

void qs_struct(items,left,right);
void quick_struct(items,count);
int BinarySeach(items,name,n);
void print_data(point);

int main(void)
{
	char name[30];
	int i; 
	printf("将原始数据排序\n");
	quick_struct(SDatas,NUM);
	printf("请输入要查找人的名字：\n");
	scanf("%s",name);
	i = BinarySeach(SDatas,name,NUM);
	if(i == -1)
	{
		printf("没有查找到该人信息\n");
		return 0;
	}
	printf("查找结果：\n");
	print_data(&SDatas[i]);
	return 1;
}


void quick_struct(items,count)
struct Data items[];      //要排序的结构体数组头指针 
int count;                //元素个数 
{
	qs_struct(items,0,count-1);
}

void qs_struct(items,left,right)
struct Data items[];      //头指针 
int left;                 //结构体数组的最左端
int right;                //结构体数组的最右端 
{
	register int i,j;
	char *x;
	struct Data temp;     //临时结构体，用于交换数据 
	i = left;
	j = right;
	x = items[(left+right/2)].name;
	do
	{
		while((strcmp(items[i].name,x)<0)&&(i<right))
			i++;
		while((strcmp(items[j].name,x)>0)&&(j>left))
			j--;
		if(i<=j)
		{
			temp = items[i];
			items[i] = items[j];
			items[j] = temp;
			i++;
			j--;
		}
	}while(i<=j);
	if(left<j)
		qs_struct(items,left,j);
	if(i<right)
		qs_struct(items,i,right);
}

int BinarySeach(items,name,n)     //二分法查找 
struct Data items[];
char name[];                      //关键字 
int n;
{
	int low,high,mid;
	low = 0;
	high = n-1;
	while(low<=high)
	{
		mid = (low+high)/2;     //取中间数比较 
		if((strcmp(items[mid].name,name)==0))
			return mid;
		else if((strcmp(items[mid].name,name)<0))
			low = mid+1;
		else high = mid-1;
	}
	return -1;
}

void print_data(point)
struct Data *point;
{
	if(point ==NULL)
		return;
	printf("	姓名：%s\n",point->name);
	printf("	城市：%s\n",point->city);
	printf("	性别：%s\n",point->sex);
	printf("	年龄：%s\n",point->age);
	printf("	工作：%s\n",point->job);
}