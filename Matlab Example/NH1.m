function r=nh1(x1,x2)
if abs(x1-x2)<1e-6
    r=cos(x1);
else
    r=(nh0(x1)-nh0(x2))/(x1-x2);
end