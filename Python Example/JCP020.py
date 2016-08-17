'''
【程序20】
题目：一球从100米高度自由落下，每次落地后反跳回原高度的一半；再落下，求它在
　　　第10次落地时，共经过多少米？第10次反弹多高？
1.程序分析：见下面注释
2.程序源代码：
'''
Sn = 100.0
Hn = Sn / 2

for n in range(2,11):
    Sn += 2 * Hn
    Hn /= 2

print 'Total of road is %f' % Sn
print 'The tenth is %f meter' % Hn
