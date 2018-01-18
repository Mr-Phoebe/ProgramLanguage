function [x,st]=jac(a,b,n,x1)
D=zeros(n,n);
L=zeros(n,n);
U=zeros(n,n);
for i=1:n
    for j=1:n
        if j==i
            D(i,j)=a(i,j);
        end
        if j<i
            L(i,j)=-a(i,j);
        end
        if j>i
            U(i,j)=-a(i,j);
        end
    end
end
D2=inv(D);
Bj=D2*(L+U);
fj=D2*b;
k=1;
x2=Bj*x1+fj;
e=x2-x1;
while norm(e,2)>1e-6
    k=k+1;
    x1=x2;
    x2=Bj*x1+fj;
    e=x2-x1;
end
st=k;
x=x2;