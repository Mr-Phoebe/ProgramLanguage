#include <stdio.h>

void Mpass(int x[],int y[],int k,int n);	/*声明其为函数*/
void Msort(int x[],int y[],int n);			/*声明其为函数*/

int main(void)
{
	/*要排序整型数据序列*/
	int a[] = {26,5,37,1,61,11,59,15,48,19};
	int y[10];				/*用于暂时存储数据*/
	int i;
	printf("源数据为：	   ");	/*将源数据打印出来*/
	for(i = 0;i<10;i++)
	printf("[%2d]",a[i]);
	Msort(a,y,10);		/*对源数据进行合并排序*/
	printf("\n排序后的数据为:  ");
	for(i = 0;i<10;i++)			/*将排序结果打印出来*/
	printf("%4d",a[i]);
	printf("\n");
	return 0;
}

void Mpass(x,y,k,n)
int x[];					/*要排序的数组*/
int y[];					/*用于存储临时数据的数组*/
int k;				/*表示当前序列中有若干长度为k的相邻有序子序*/
int n;				/*要排序序列的长度为n*/
	
{
	int i,j;
	int	strat1,end1;	/*对应第一个有序子序列L1起始和终止位置号*/
	int	strat2,end2;	/*对应第二个有序子序列L2起始和终止位置号*/
	int	m;				/*表示输入y中当前记录应放置的位置号*/
	strat1 = 0;
	m = 0;
	while(strat1+k<=n-1)		/*当第一个子序列没有占据整个x数组*/
	{
		strat2 = strat1+k;		/*为两个有序子序列起始终止位置号赋值*/
		end1 = strat2-1;
		/*如果第二的子序列长度不够k，则其终止位置号为n-1*/
		end2 = (strat2+k-1<=n-1)?strat2+k-1:n-1;
		for(i = strat1,j = strat2;i<=end1&&j<=end2;m++)
		{
			if(x[i]<=x[j])
			{
				y[m] = x[i];
				i++;
			}
			else
			{
				y[m] = x[j];
				j++;
			}
		}
		while(i<= end1)
		{
			y[m] = x[i];
			m++;
			i++;
		}
		while(j<= end2)
		{
			y[m] = x[j];
			m++;
			j++;
		}
		strat1 = end2+1;
	}
	/*将另一个序列中剩余的所有记录依次放到数组y中*/
	for(i=strat1;i<n;i++,m++)		
		y[m] = x[i];
}

void Msort(x,y,n)
int x[];			/*要排序的数组*/
int y[];			/*用于存储临时数据的数组*/
int n;				/*数组长度*/
{
	int i,k,count;
	k = 1;
	count = 1;
	while(k<n)				/*当子序列比整个序列小时*/
	{
		Mpass(x,y,k,n);		/*归并两有序子序列*/	
		for(i= 0;i<n;i++)
			x[i] = y[i];	/*返回数据*/
		printf("\n第%2d步后的结果==>  ",count++);
			for(i = 1;i<n+1;i++)
		{
			if((i ==n)&&((i%(2*k)!=0)))
				printf("%4d]",x[i-1]);
			else
			{
				if((i%(2*k)==1))
					printf("[%2d",x[i-1]);
				else if((i%(2*k))==0)
					printf("%4d]",x[i-1]);
				else
					printf("%4d",x[i-1]);
			}
		}
		k = 2*k;		/*一次归并后新的有序子序列的长度*/
	}
}



