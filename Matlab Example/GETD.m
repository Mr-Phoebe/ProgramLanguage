function [x,st]=getd(a,b,n,x1)
r1=b-a*x1;
p1=r1;
e=ones(n,1);
k=0;
while (norm(e,2)>1e-6)&(norm(r1,2)>1e-6)
    k=k+1;
    alpha=dot(r1,r1)/dot(p1,a*p1);
    x2=x1+alpha*p1;
    r2=r1-alpha*a*p1;
    beta=dot(r2,r2)/dot(r1,r1);
    p2=r2+beta*p1;
    e=x2-x1;
    x1=x2;
    p1=p2;
    r1=r2;
end
st=k;
x=x2;