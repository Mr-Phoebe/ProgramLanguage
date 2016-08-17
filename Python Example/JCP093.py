'''
【程序93】
题目：时间函数举例3
1.程序分析：
2.程序源代码：
'''
if __name__ == '__main__':
    import time
    start = time.clock()
    for i in range(10000):
        print i
    end = time.clock()
    print 'different is %6.3f' % (end - start)
    
