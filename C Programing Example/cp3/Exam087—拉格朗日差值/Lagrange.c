#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>

double LAG(int,double *,double *,double);

void main()
{
	int n;
	double *x,*y,t,lag;
	t = 0.15;
	n = 6;
	x = (double*)calloc(n,sizeof(double));
	if(x == NULL)
	{
		printf("内存分配失败\n");
		exit(1);
	}
	y = (double*)calloc(n,sizeof(double));
	if(y == NULL)
	{
		printf("内存分配失败\n");
		exit(1);
	}
	x[0] = 0;
	x[1] = 0.1;
	x[2] = 0.195;
	x[3] = 0.3;
	x[4] = 0.401;
	x[5] = 0.5;

	y[0] = 0.39894;
	y[1] = 0.39695;
	y[2] = 0.39142;
	y[3] = 0.38138;
	y[4] = 0.36812;
	y[5] = 0.35206;

	lag = LAG(n,x,y,t);
	printf("拉各朗日插值后得到的结果是：\n");
	printf("f(%.2f)=%e\n",t,lag);
	free(x);
	free(y);
}

double LAG(n,x,y,t)
int n;
double *x;
double *y;
double t;
{
	int i,j;
	double p,s;
	s = 0;
	for(i=0;i<n-1;i++)
	{
		p = 1;
		for(j=0;j<n-1;j++)
			if(i!=j)
				p*=(t-x[j])/(x[i]-x[j]);
			s+=p*y[i];
	}
	return (s);
}
