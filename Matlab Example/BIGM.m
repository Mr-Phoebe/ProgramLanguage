function r=bigm(x,h,n)
A=zeros(n,n);
d=zeros(n,1);
a(1)=1;
d(1)=6*s2(x(1),x(1),x(2));
b(n)=1;
d(n)=6*s2(x(n-1),x(n),x(n));
for j=2:n-1
    b(j)=h/(h+h);
    a(j)=1-b(j);
    d(j)=6*s2(x(j-1),x(j),x(j+1));
end
A(1,1)=2;
A(1,2)=a(1);
A(n,n-1)=b(n);
A(n,n)=2;
for i=2:n-1
    A(i,i-1)=b(i);
    A(i,i)=2;
    A(i,i+1)=a(i);
end
r=inv(A)*d;