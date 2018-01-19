/*
* @Author: Haonan Wu
* @Date:   2018-01-19 16:06:29
* @Last Modified by:   Haonan Wu
* @Last Modified time: 2018-01-19 16:07:57
*/

object Drunkard {
    //最开始拥有的软妹币  
    var money = 10

    //每天喝掉一个软妹币  
    def drink: Unit = {
        money -= 1
    }

    //数钱时要算上被喝掉的软妹币  
    def count: Int = {
        drink
        money
    }

    //每天都数钱  
    def printByName(x: => Int): Unit = {
        for (i <- 0 until 5)
            println("每天算一算，酒鬼还剩" + x + "块钱！")
    }

    //第一天数一下记墙上，以后每天看墙上的余额  
    def printByValue(x: Int): Unit = {
        for (i <- 0 until 5)
            println("只算第一天，酒鬼还剩" + x + "块钱！")
    }

    def main(args: Array[String]) = {
        printByName(count)
        printByValue(count)
    }
}

/*
scala中的call-by-name和call-by-value.md
===

var/def/val/lazy val
---

- def：类似于每一次重新赋值，如果是用def定义函数，则是每一次重新获得一个函数，做call-by-name操作。
- val：获得一次，并立即执行，且在生命周期内不能再被修改，使用的是call-by-value操作。
- var：在生命周期内可以被再次赋值
- lazy val：惰性执行，也就是赋值(绑定)的时候先不会执行，等到需要的时候再执行

### 例子

```scala
scala> def f = {println("hello"); 1.0}
f: Double

scala> f
hello
res3: Double = 1.0

scala> f
hello
res4: Double = 1.0

scala> f
hello
res5: Double = 1.0
```

这里使用的是def，则每次使用的时候相当于获取一个新的函数。  
体现是，每一次使用f的时候，都会获得一个`{ println(“hello”); 1.0}`，其返回值为1，但是中间过程会打印出hello，这是在赋值（绑定）的时候才会打印出来的。

```scala
scala> val f = { println("hello"); 1.0}
hello
f: Double = 1.0

scala> f
res6: Double = 1.0

scala> f
res7: Double = 1.0
```

这里使用val，则只有一次绑定，所以后面不再打印出hello。如果觉得迷糊，可以继续看下去。

```scala
scala> lazy val f = { println("hello"); 1.0}
f: Double = <lazy>

scala> f
hello
res8: Double = 1.0

scala> f
res9: Double = 1.0
```

这里使用的是lazy val,即为惰性求值的。可以看到在进行绑定的时候并没有打印出hello，也看不到其值，是因为只是定义了这个值。

在第二次进行使用的时候则会真正去计算这个值（类似于val），第一次会打印出hello，之后就不再打印出了

函数定义中的call-by-name和call-by-value
---

看了上面的讲解还觉得迷糊的，就是不太理解call-by-name和call-by-value。

scala的call by name 和call by value最大的区别就是：

**call-by-name在调用的时候会重新根据name做计算，而call-by-value预先计算，然后保留计算值后一直使用这个value。**

### 纯函数例子<sup>[[1]](#1)</sup>

一个Stack Overflow的例子。

```scala
def something() = {
  println("calling something")
  1 // return value
}

def callByValue(x: Int) = {
  println("x1=" + x)
  println("x2=" + x)
}

def callByName(x: => Int) = {
  println("x1=" + x)
  println("x2=" + x)
}

scala> callByValue(something())
calling something
x1=1
x2=1

scala> callByName(something())
calling something
x1=1
calling something
x2=1
```

这是因为在调用函数之前，call-by-value会先计算传入的表达式的值，因此每次都访问相同的值，且也不会再次调用。 

但是，call-by-name，每次应用的时候，都会重新计算传入的表达式的值。

### 不纯函数的例子<sup>[[2]](#2)</sup>

上的都是纯函数，下面写一个非纯函数可能会更加明显。

举一个例子，假设有一只酒鬼，他最初有十元钱，每天喝酒都会花掉一元钱。设他有一个技能是数自己的钱，返回每天他口袋里钱的最新数目。

```scala
object Drunkard {
    //最开始拥有的软妹币  
    var money = 10

    //每天喝掉一个软妹币  
    def drink: Unit = {
        money -= 1
    }

    //数钱时要算上被喝掉的软妹币  
    def count: Int = {
        drink
        money
    }

    //每天都数钱  
    def printByName(x: => Int): Unit = {
        for (i <- 0 until 5)
            println("每天算一算，酒鬼还剩" + x + "块钱！")
    }

    //第一天数一下记墙上，以后每天看墙上的余额  
    def printByValue(x: Int): Unit = {
        for (i <- 0 until 5)
            println("只算第一天，酒鬼还剩" + x + "块钱！")
    }

    def main(args: Array[String]) = {
        printByName(count)
        printByValue(count)
    }
}
/*
每天算一算，酒鬼还剩9块钱！  
每天算一算，酒鬼还剩8块钱！  
每天算一算，酒鬼还剩7块钱！  
每天算一算，酒鬼还剩6块钱！  
每天算一算，酒鬼还剩5块钱！  
只算第一天，酒鬼还剩4块钱！  
只算第一天，酒鬼还剩4块钱！  
只算第一天，酒鬼还剩4块钱！  
只算第一天，酒鬼还剩4块钱！  
只算第一天，酒鬼还剩4块钱！
*/  
```

可以看到，酒鬼最初5天每天都会数一下口袋里的软妹币(call-by-name)，得到了每天喝酒花钱之后剩下的软妹币数量。

他觉得麻烦，于是想出了一个聪明的方法，在第六天的时候，他将口袋里还剩下的余额数写在了墙上(call-by-value)，以后每天看一下墙上的数字，就知道自己还剩多少钱了。

### 死循环例子

我们可以写出一个函数递归的"循环"。

如果在call-by-name下会停止，并不表示着在call-by-value下会停止。
但是，如果call-by-value停止了，call-by-name一定会停止。

```scala
// 这是一个死循环
 def loop: Boolean = loop

 // 用val定义时会做call-by-value，以下语句会block住
 val x = loop 

 // 用def定义时，是做的call-by-name。故以下语句暂时不会执行，在用到y的时候才做evaluation
 def y = loop
```

### 两者的比较

call-by-value在进入函数体之前就对参数表达式进行了计算，这避免了函数内部多次使用参数时重复计算其值，在一定程度上提高了效率。

但是call-by-name的一个优势在于，如果参数在函数体内部没有被使用到，那么它就不用计算参数表达式的值了。在这种情况下，call-by-name的效率会高一点。

```scala
object Main {

    def useOrNotUse(flag: Boolean, x: Int, y: => Int) = {
        if (flag) {
            x
        }
        else {
            x + y
        }
    }

    def main(args: Array[String]) = {
        val flag = true
        println(useOrNotUse(flag, 1, 2))
        val flag = false
        println(useOrNotUse(flag, 1, 2))
    }
}  
```

## 参考资料

1. <div id="1">[Call by name vs call by value in Scala, clarification needed](https://stackoverflow.com/questions/13337338/call-by-name-vs-call-by-value-in-scala-clarification-needed)</div>
2. [scala中的var,val,immutable,mutable理解小结](http://blog.csdn.net/shen_jz2012/article/details/50320929)
3. <div id="2">[scala中的call-by-name和call-by-value](http://blog.csdn.net/asongoficeandfire/article/details/21889375)</div>
*/