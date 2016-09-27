# -*- coding: UTF-8 -*-
'''
【程序77】
题目：填空练习（指向指针的指针）
1.程序分析：　　　　　
2.程序源代码：
'''
if __name__ == '__main__':
    s = ["man","woman","girl","boy","sister"]
    for i in range(len(s)):
        for j in range(len(s[i])):
            print s[i][j],
        print ""
        
