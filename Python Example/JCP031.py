'''
程序31】
题目：请输入星期几的第一个字母来判断一下是星期几，如果第一个字母一样，则继续
　　　判断第二个字母。
1.程序分析：用情况语句比较好，如果第一个字母一样，则判断用情况语句或if语句判断第二个字母。
2.程序源代码：
'''
from sys import stdin
letter = stdin.read(1)
stdin.flush()
while letter  != 'Y':
    if letter == 'S':
        print 'please input second letter'
        letter = stdin.read(1)
        stdin.flush()
        if letter == 'a':
            print 'Saturday'
        elif letter  == 'u':
            print 'Sunday'
        else:
            print 'data error'
            break
    elif letter == 'F':
        print 'Friday'
        break
    elif letter == 'M':
        print 'Monday'
        #break
    elif letter == 'T':
        print 'please input second letter'
        letter = stdin.read(1)
        stdin.flush()
        if letter  == 'u':
            print 'Tuesday'
        elif letter  == 'h':
            print 'Thursday'
        else:
            print 'data error'
            break
    elif letter == 'W':
        print 'Wednesday'
    else:
        print 'data error'
    letter = stdin.read(1)
    stdin.flush()
        
