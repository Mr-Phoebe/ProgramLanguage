'''
【程序41】
题目：学习static定义静态变量的用法　　　
1.程序分析：
2.程序源代码：
'''
# python没有这个功能了,只能这样了:)
def varfunc():
    var = 0
    print 'var = %d' % var
    var += 1
if __name__ == '__main__':
    for i in range(3):
        varfunc()

# attribut of class
# 作为类的一个属性吧
class Static:
    StaticVar = 5
    def varfunc(self):
        self.StaticVar += 1
        print self.StaticVar

print Static.StaticVar
a = Static()
for i in range(3):
    a.varfunc()
