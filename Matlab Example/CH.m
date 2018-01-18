function u=ch(a,b,n)
l=zeros(n,n);
l(1,1)=sqrt(a(1,1));
for i=2:n
    l(i,1)=a(i,1)/l(1,1);
end
for j=2:n
    s=0;
    for k=1:j-1
        s=s+l(i,k).^2;
    end
    l(j,j)=sqrt(a(j,j)-s);
    for i=j+1:n
        s=0;
        for k=1:j-1
            s=s+l(i,k)*l(j,k);
        end
        l(i,j)=(a(i,j)-s)/l(j,j);
    end
end
y(1)=b(1)/l(1,1);
for i=2:n
    s=0;
    for r=1:i-1
        s=s+l(i,r)*y(r);
    end
    y(i)=(b(i)-s)/l(i,i);
end
x(n)=y(n)/l(n,n);
for i=n-1:-1:1
    s=0;
    for r=i+1:n
        s=s+l(r,i)*x(r);
    end
    x(i)=(y(i)-s)/l(i,i);
end
u=x;