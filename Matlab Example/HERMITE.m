function H=hermite(t,x1,x2)
a1=(1+2*(t-x1)/(x2-x1))*((t-x2)/(x1-x2)).^2;
a2=(1+2*(t-x2)/(x1-x2))*((t-x1)/(x2-x1)).^2;
b1=(t-x1)*((t-x2)/(x1-x2)).^2;
b2=(t-x2)*((t-x1)/(x2-x1)).^2;
H=sin(x1)*a1+sin(x2)*a2+cos(x1)*b1+cos(x2)*b2;
