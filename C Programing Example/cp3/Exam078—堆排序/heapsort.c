#include <stdio.h>
#define MARK 0

static a[8] = {MARK,25,4,36,1,60,10,58,};
int count = 1;
void heap(int n);
void adjust(int i,int n);

int main(void)
{
	int i;
	printf("源数据为：");
	for(i = 1;i<8;i++)
		printf("%5d",a[i]);
	heap(7);
	printf("\n排序后的数据为：");
	for(i = 1;i<8;i++)
		printf("%5d",a[i]);
	printf("\n");
	return 0;
}

void heap(n)
int n;
{
	int i,j,t;
	for(i =n/2;i>0;i--)
		adjust(i,n);
	printf("\n初始化成堆===>   ");
	for(i = 1;i < 8;i++)
		printf("%5d",a[i]);
	for(i = n-1;i>0;i--)
	{
		t = a[i+1];
		a[i+1] = a[1];
		a[1] = t;
		adjust(1,i);
		printf("\n第%2d步操作结果===>",count++);
		for(j = 1;j<8;j++)
			printf("%5d",a[j]);
	}
}

void adjust(i,n)
int i,n;
{
	int j,k,r,done=0;
	k = r = a[i];
	j = 2*i;
	while((j<=n)&&(done==0))
	{
		if(j<n)
		{
			if(a[j]<a[j+1])
				j++;
		}
		if(k>=a[j])
			done = 1;
		else
		{
			a[j/2] = a[j];
			j = 2*	j;
		}
	}
	a[j/2] = r;
}


