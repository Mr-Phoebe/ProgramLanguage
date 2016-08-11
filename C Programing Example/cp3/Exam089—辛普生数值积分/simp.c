#include <stdio.h>
#include <math.h>

double Function(double);
double SIMP1(double,double,int);
double SIMP2(double,double,double);

void main()
{
	double a1,b1,eps;
	int n1;
	double Result1;
	double Result2;
	a1 = 0.0;
	b1 = 0.8;
	n1 = 4;
	eps = 5e-7;
	Result1 = SIMP1(a1,b1,n1);
	Result2 = SIMP2(a1,b1,eps);
	printf("利用定步长辛普生积分结果为：\n");
	printf("I1 = %.10f\n",Result1);
	printf("利用变步长辛普生积分结果为：\n");
	printf("I2 = %e\n",Result2);
}

double SIMP1(a,b,n)
double a;
double b;
int n;
{
	int i;
	double h,s;
	h=(a-b)/(2*n);
	s=0.5*(Function(a)-Function(b));
	for(i=1;i<=n;i++)
		s+=2*Function(a+(2*i-1)*h)+Function(a+2*i*h);
	return((b-a)*s/(3*n));
}

double SIMP2(a,b,eps)
double a;
double b;
double eps;
{
	int k,n;
	double h,t1,t2,s1,s2,p,x;
	n=1;
	h=b-a;
	t1=h*(Function(a)+Function(b))/2;
	s1 = t1;
	while(1)
	{
		p = 0;
		for(k=0;k<=n;k++)
		{
			x = a+(k+0.5)*h;
			p+=Function(x);
		}
		t2=(t1+h*p)/2;
		s2=(4*t2-t1)/3;
		if(fabs(s2-s1)>=eps)
		{
			t1=t2;
			n=n+n;
			h=h/2;
			s1=s2;
			continue;
		}
		break;
	}
	return(s2);
}

double Function(double x)
{
	return(cos(x));
}