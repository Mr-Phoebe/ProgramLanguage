'''
【程序43】
题目：学习使用static的另一用法。　　　
1.程序分析：
2.程序源代码：
有一个static变量的用法，python是没有，演示一个python作用域使用方法
'''
class Num:
    nNum = 1
    def inc(self):
        self.nNum += 1
        print 'nNum = %d' % self.nNum

if __name__ == '__main__':
    nNum = 2
    inst = Num()
    for i in range(3):
        nNum += 1
        print 'The num = %d' % nNum
        inst.inc()
