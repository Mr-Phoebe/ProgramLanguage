function rel=dirang(a,b,n)
l=eye(n,n);
u=zeros(n,n);
for j=1:n
    u(1,j)=a(1,j);
end
for i=2:n
    l(i,1)=a(i,1)/u(1,1);
end
for k=2:n
    for j=k:n
        s=0;
        for r=1:k-1
            s=s+l(k,r)*u(r,j);
        end
        u(k,j)=a(k,j)-s;
    end
    for i=k+1:n
        s=0;
        for r=1:k-1
            s=s+l(i,r)*u(r,k);
        end
        l(i,k)=(a(i,k)-s)/u(k,k);
    end
end
y(1)=b(1);
for i=2:n
    s=0;
    for r=1:i-1
        s=s+l(i,r)*y(r);
    end
    y(i)=b(i)-s;
end
x(n)=y(n)/u(n,n);
for i=n-1:-1:1
    s=0;
    for r=i+1:n
        s=s+u(i,r)*x(r);
    end
    x(i)=(y(i)-s)/u(i,i);
end
rel=x;