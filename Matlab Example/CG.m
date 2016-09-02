function [x,st]=cg(a,b,n,x1)
r=b-a*x1;
alpha=dot(r,r)/dot(a*r,r);
x2=x1+alpha*r;
e=x2-x1;
k=1;
while norm(e,2)>1e-6
    k=k+1;
    x1=x2;
    r=b-a*x1;
    alpha=dot(r,r)/dot(a*r,r);
    x2=x1+alpha*r;
    e=x2-x1;
end
x=x2;
st=k;