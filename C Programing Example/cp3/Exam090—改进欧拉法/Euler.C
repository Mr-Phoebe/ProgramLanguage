
#include "stdio.h"
#include "stdlib.h"
#include <math.h>

int Func(y,d)
double y[],d[];
{
	d[0]=y[1];		/*y0'=y1*/
	d[1]=-y[0];		/*y1'=y0*/
	d[2]=-y[2];		/*y2'=y2*/
	return(1);
}

void Euler1(t,y,n,h,k,z)
int n;		/*整型变量，微分方程组中方程的个数，也是未知函数的个数*/
int k;		/*整型变量。积分步数(包括起始点这一步)*/
double t;		/*双精度实型变量,对微分方程进行积分的起始点t0*/
double h;		/*双精度实型变量。积分步长*/
double y[];	/*双精度实型一维数组，长度为n。存放n个未知函数yi在起始点t0处的函数值*/
double z[];	/*双精度实型二维数组，体积为nxk。返回k个积分点(包括起始点)上的未知函数值*/
{ 
	extern int Func();
	int i,j;
	double *d;
	d=malloc(n*sizeof(double));
	if(d == NULL)
	{
		printf("内存分配失败\n");
		exit(1);
	}
	/*将方程组的初值赋给数组z[i*k]*/
	for (i=0; i<=n-1; i++)
		z[i*k]=y[i];
	for (j=1; j<=k-1; j++)
	{
		Func(y,d);			/*求出f(x)*/
		for(i=0; i<=n-1; i++)
			y[i]=z[i*k+j-1]+h*d[i];

		Func(y,d);
		for (i=0; i<=n-1; i++)
			d[i]=z[i*k+j-1]+h*d[i];
		for (i=0; i<=n-1; i++)
		{
			y[i]=(y[i]+d[i])/2.0;
			z[i*k+j]=y[i];
		}
	}
    free(d); 
	return;
  }
void Euler2(t,h,y,n,eps)
int n;
double t,h,eps,y[];
{
	int i,j,m;
	double hh,p,q,*a,*b,*c,*d;
    a=malloc(n*sizeof(double));
    b=malloc(n*sizeof(double));
    c=malloc(n*sizeof(double));
    d=malloc(n*sizeof(double));
    hh=h;
	m=1; 
	p=1.0+eps;
	for (i=0; i<=n-1; i++) a[i]=y[i];
    while (p>=eps)
    {
		for (i=0; i<=n-1; i++)
        {
			b[i]=y[i];
			y[i]=a[i];
		}
        for (j=0; j<=m-1; j++)
        {
			for (i=0; i<=n-1; i++) 
				c[i]=y[i];
            Func(y,d);
            for (i=0; i<=n-1; i++)
                y[i]=c[i]+hh*d[i];
            Func(y,d);
            for (i=0; i<=n-1; i++)
                d[i]=c[i]+hh*d[i];
            for (i=0; i<=n-1; i++)
                y[i]=(y[i]+d[i])/2.0;
        }
        p=0.0;
        for (i=0; i<=n-1; i++)
        {
			q=fabs(y[i]-b[i]);
            if (q>p) p=q;
        }
        hh=hh/2.0; m=m+m;
	}
    free(a); 
	free(b); 
	free(c);
	free(d);
	return;
}
main()
{
	int i,j;
	double y[3],z[3][11],t,h,x,eps;
	y[0]=-1.0;			/*初值y0(0)=-1.0*/
	y[1]=0.0;			/*初值y1(0)=-1.0*/
	y[2]=1.0;			/*初值y2(0)=-1.0*/
	t=0.0;				/*起始点t=0*/
	h=0.01;				/*步长为0.01*/
	eps = 0.00001;
	Euler1(t,y,3,h,11,z);
	printf("定步长欧拉法结果：\n");
	for (i=0; i<=10; i++)
	{
		x=i*h;
		printf("t=%5.2f\t   ",x);
		for(j=0; j<=2; j++)
			printf("y(%d)=%e  ",j,z[j][i]);
		printf("\n");
	}
	y[0]=-1.0;			/*重新赋初值*/
	y[1]=0.0;			
	y[2]=1.0;			
	printf("变步长欧拉法结果：\n");
	printf("t=%5.2f\t   ",t);
	for (i=0; i<=2; i++)
		printf("y(%d)=%e  ",i,y[i]);
	printf("\n");
	for (j=1; j<=10; j++)
	{
		Euler2(t,h,y,3,eps);
		t=t+h;
		printf("t=%5.2f\t   ",t);
		for (i=0; i<=2; i++)
			printf("y(%d)=%e  ",i,y[i]);
		printf("\n");
	}
}

