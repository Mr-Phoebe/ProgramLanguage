function [x,st]=sor(a,b,n,x1)
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
opt=oumiga(a);
Bsor=inv(D-opt*L)*[(1-opt)*D+opt*U];
fsor=opt*inv(D-opt*L)*b;
k=1;
x2=Bsor*x1+fsor;
e=x2-x1;
while norm(e,2)>1e-6
    k=k+1;
    x1=x2;
    x2=Bsor*x1+fsor;
    e=x2-x1;
end
x=x2;
st=k;