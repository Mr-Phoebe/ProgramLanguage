function s=lagrange(t,n)
for i=1:n
    h=2*pi/n;
    x(i)=i*h;
end
s=0;
for i=1:n
    l=1;
    for j=1:n
        if j~=i
            l=l*(t-x(j))/(x(i)-x(j));
        end
    end
    s=s+sin(x(i))*l;
end