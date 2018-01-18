#include <stdio.h>
#include <math.h>
#include <stdlib.h>

int Function(double,double *,double *);
int Newton(double *,double,int);

int Function(x,f,dy)
double x;
double *f;
double *dy;
{
	*f = x*x*(x-1)-1;
	*dy = 3*x*x-2*x;
	return(1);
}

int Newton(x,eps,l)
double *x;
double eps;
int l;
{
	double f,dy,x1;
	Function(*x,&f,&dy);
A:	if(fabs(dy) == 0)
	{
		l = 0;
		return (0);
	}
	x1=*x-f/dy;
	Function(x1,&f,&dy);
	if(fabs(x1-*x)>=eps||fabs(f)>=eps)
	{
		l-=1;
		*x=x1;
		if(l==0)
			return(1);
		goto A;
	}
	*x = x1;
	return 1;
}

void main()
{
	double x,eps;
	int l;
	eps=1.e-6;
	x=1.5;
	l=60;
	if(!Newton(&x,eps,l))
	{
		printf("该函数不可以用牛顿跌代法求根!\n");
	}
	printf("利用牛顿跌代法求的的根为：\n");
	printf("x=%.10f\n",x);
}