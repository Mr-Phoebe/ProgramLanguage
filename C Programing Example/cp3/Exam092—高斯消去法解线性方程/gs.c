#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include <math.h>

int GS(int,double**,double *,double);
double **TwoArrayAlloc(int,int);
void TwoArrayFree(double **);

void main()
{
	int i,n;
	double ep,**a,*b;
	n = 3;
	ep = 1e-4;
	a = TwoArrayAlloc(n,n);
	b = (double *)calloc(n,sizeof(double));
	if(b == NULL)
	{
		printf("内存分配失败\n");
		exit(1);
	}
	a[0][0]= 2; a[0][1]= 6; a[0][2]=-1;
	a[1][0]= 5; a[1][1]=-1; a[1][2]= 2;
	a[2][0]=-3; a[2][1]=-4; a[2][2]= 1;
	b[0] = -12; b[1] = 29;  b[2] = 5;
	if(!GS(n,a,b,ep))
	{
		printf("不可以用高斯消去法求解\n");
		exit(0);
	}
	printf("该方程组的解为：\n");
	for(i=0;i<3;i++)
		printf("x%d = %.2f\n",i,b[i]);
	TwoArrayFree(a);
	free(b);
}

int GS(n,a,b,ep)
int n;
double **a;
double *b;
double ep;
{
	int i,j,k,l;
	double t;
	for(k=1;k<=n;k++)
	{
		for(l=k;l<=n;l++)
			if(fabs(a[l-1][k-1])>ep)
				break;
			else if(l==n)
				return(0);
		if(l!=k)
		{
			for(j=k;j<=n;j++)
			{
				t = a[k-1][j-1];
				a[k-1][j-1]=a[l-1][j-1];
				a[l-1][j-1]=t;
			}
			t=b[k-1];
			b[k-1]=b[l-1];
			b[l-1]=t;
		}
		t=1/a[k-1][k-1];
		for(j=k+1;j<=n;j++)
			a[k-1][j-1]=t*a[k-1][j-1];
		b[k-1]*=t;
		for(i=k+1;i<=n;i++)
		{
			for(j=k+1;j<=n;j++)
				a[i-1][j-1]-=a[i-1][k-1]*a[k-1][j-1];
			b[i-1]-=a[i-1][k-1]*b[k-1];
		}
	}
	for(i=n-1;i>=1;i--)
		for(j=i+1;j<=n;j++)
			b[i-1]-=a[i-1][j-1]*b[j-1];
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