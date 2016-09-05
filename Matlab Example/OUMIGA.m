function r=oumiga(a)
n=length(a);
x1=zeros(n,1);
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
rou=max(abs(eig(Bj)));
r=2/(1+sqrt(1-rou.^2));