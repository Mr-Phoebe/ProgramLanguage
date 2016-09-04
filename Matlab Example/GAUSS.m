function u=gauss(a,n)
for k=1:n-1
    for i=k+1:n
        for j=k+1:n+1
            if abs(a(k,k))>1e-6
                a(i,j)=a(i,j)-a(i,k)/a(k,k)*a(k,j);
            else
                msgbox('Gauss消去失败','计算结果');
                pause;
                exit;
            end
        end
    end
end
x(n)=a(n,n+1)/a(n,n);
for i=n-1:-1:1
    s=0;
    for j=i+1:n
        s=s+a(i,j)*x(j);
    end
    x(i)=(a(i,n+1)-s)/a(i,i);
end
u=x;