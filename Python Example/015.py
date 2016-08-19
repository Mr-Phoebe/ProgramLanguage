#--coding:utf-8--
'''
【程序15】
题目：学习成绩>=90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示。
Python中没有三目运算符
'''
score = int(raw_input('input score:\n'))
if score >= 90:
    grade = 'A'
elif score >= 60:
    grade = 'B'
else:
    grade = 'C'

print '%d belongs to %s' % (score,grade)
