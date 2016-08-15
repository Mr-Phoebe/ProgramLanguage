#--coding:utf-8--
'''
【程序8】
题目：输出9*9口诀。
'''
for i in range(1,10):
    for j in range(1,10):
        result = i * j
        print '%d * %d = % -3d' % (i,j,result)
    print ''
    
