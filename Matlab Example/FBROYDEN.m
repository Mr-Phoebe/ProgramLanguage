function [U,st]=fbroyden(X,n)
k=0;
e=ones(n,1);
B=inv(df(X));
while norm(e,2)>1e-6
    k=k+1;
    X1=X;
    dX=B*f(X);
    X=X-dX;
    p=X-X1;
    q=f(X)-f(X1);
    B=B+((p-B*q)*p'*B)/(p'*B*q);
    e=dX;
end
U=X;
st=k;