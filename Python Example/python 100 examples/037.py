# -*- coding: UTF-8 -*-
'''
������37��
��Ŀ����10������������
1.�����������������ѡ�񷨣����Ӻ�9���ȽϹ����У�ѡ��һ����С�����һ��Ԫ�ؽ�����
�������������´����ƣ����õڶ���Ԫ�����8�����бȽϣ������н����� ������������ 
2.����Դ���룺 
'''
import random
if __name__ == "__main__":
    N = 10
    # input data
    # print 'please input ten num:\n'
    l = []
    for i in range(N):
        l.append(random.randint(1,50))
        # l.append(int(raw_input('input a number:\n')))
    print 'before sorted\n'
    print l

    # sort ten num
    for i in range(N - 1):
        min = i
        for j in range(i + 1,N):
            if l[min] > l[j]:min = j
        l[i],l[min] = l[min],l[i]
    print 'after sorted\n'
    print l

                 