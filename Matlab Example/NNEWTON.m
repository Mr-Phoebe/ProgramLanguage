function [U,st]=nnewton(X,n)
k=0;
e=ones(n,1);
while norm(e,2)>1e-6
    k=k+1;
    A=df(X);
    dX=inv(A)*f(X);
    X=X-dX;
    e=dX;
end
U=X;
st=k;