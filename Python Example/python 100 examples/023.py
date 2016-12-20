#--coding:utf-8--
'''
【程序23】 
题目：打印出如下图案（菱形）

   *
  ***
 *****
*******
 *****
  ***
   * 
'''
from sys import stdout
for i in range(4):
    for j in range(2 - i + 1):
        stdout.write(' ')
    for k in range(2 * i + 1):
        stdout.write('*')
    print

for i in range(3):
    for j in range(i + 1):
        stdout.write(' ')
    for k in range(4 - 2 * i + 1):
        stdout.write('*')
    print
