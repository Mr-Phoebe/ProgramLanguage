function [U,st]=broyden(X,n)
k=0;
e=ones(n,1);
A=df(X);
while norm(e,2)>1e-6
    k=k+1;
    X1=X;
    dX=inv(A)*f(X);
    X=X-dX;
    p=X-X1;
    q=f(X)-f(X1);
    A=A+(q-A*p)*p'/dot(p,p);
    e=dX;
end
U=X;
st=k;