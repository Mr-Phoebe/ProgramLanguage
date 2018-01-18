function r=nhermite(t,x1,x2)
r=nh0(x1)+nh1(x1,x1)*(t-x1)+nh2(x1,x1,x2)*(t-x1).^2+nh3(x1,x1,x2,x2)*(t-x1).^2*(t-x2);