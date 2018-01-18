#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>

int GJ(int,double **);
double **TwoArrayAlloc(int,int);
void TwoArrayFree(double **);

void main()
{
	int i,j,n;
	double **a;
	n=4;
	a=TwoArrayAlloc(n,n);

	a[0][0]=5;	a[0][1]=7;	a[0][2]=6;	a[0][3]=5;
	a[1][0]=7;	a[1][1]=10;	a[1][2]=8;	a[1][3]=7;
	a[2][0]=6;	a[2][1]=8;	a[2][2]=10;	a[2][3]=9;
	a[3][0]=5;	a[3][1]=7;	a[3][2]=9;	a[3][3]=10;
	if(!GJ(n,a))
	{
		printf("矩阵求逆失败\n");
		exit(1);
	}
	printf("该矩阵的逆为：\n");
	for(i=0;i<n;i++)
	{
		for(j=0;j<n;j++)
			printf("%.2f\t",a[i][j]);
		printf("\n");
	}
}

int GJ(int n,double **a)
{
	int i,j,k;
	double p,q,*h;
	h=(double *)calloc(n,sizeof(double));
	if(h == NULL)
	{
		printf("内存分配失败\n");
		exit(1);
	}
	for(k=n;k>=1;k--)
	{
		p=a[0][0];
		if(p<=0)
		{
			free(h);
			return (0);
		}
		for(i=2;i<=n;i++)
		{
			q=a[i-1][0];
			if(i>k)
				h[i-1]=q/p;
			else
				h[i-1]=-q/p;
			for(j=2;j<=i;j++)
				a[i-2][j-2]=a[i-1][j-1]+q*h[j-1];
		}
		a[n-1][n-1]=1/p;
		for(i=2;i<=n;i++)
			a[n-1][i-2]=h[i-1];
	}
	free(h);
	return(1);
}

double **TwoArrayAlloc(int r,int c)
{
	double *x,**y;
	int n;
	x=(double *)calloc(r*c,sizeof(double));
	y=(double **)calloc(r,sizeof(double*));
	for(n=0;n<=r-1;++n)
		y[n]=&x[c*n];
	return (y);
}

void TwoArrayFree(double **x)
{
	free(x[0]);
	free(x);
}