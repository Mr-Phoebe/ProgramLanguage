Scala中的Any、Nothing
===

！[](http://img.blog.csdn.net/20180127103012972?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvdTAxMzAwNzkwMA==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


Any
---

在scala中，Any类是所有类的超类。Any有两个子类：AnyVal和AnyRef。

对于直接类型的scala封装类，如Int、Double等，AnyVal是它们的基类；对于引用类型，AnyRef是它们的基类。

Any是一个抽象类，它有如下方法：!=()、==()、asInstanceOf()、equals()、hashCode()、isInstanceOf()和toString()。

AnyVal没有更多的方法了。AnyRef则包含了Java的Object类的一些方法，比如notify()、wait()和finalize()。

AnyRef是可以直接当做java的Object来用的。对于Any和AnyVal，只有在编译的时候，scala编译器才会将它们视为Object。换句话说，在编译阶段Any和AnyVal会被类型擦除为Object。

## Nothing

如上图所示，Nothing是所有类的子类，是一个类。Nothing没有对象，但是可以用来定义类型。

在Java当中你很难找到类似的东西对应Scala中的Nothing。Nothing到底是什么呢？或者换个方向考虑：Nothing的用处是什么呢？

1. 用于标记不正常的停止或者中断
2. 一个空的collection

```scala
scala> def foo = throw new RuntimeException
foo: Nothing
scala> val l:List[Int] = List[Nothing]()
l: List[Int] = List()
```

因为`List[+A]`定义是协变的，所以`List[Nothing]`是`List[Int]`的子类，但`List[Null]`不是`List[Int]`的子类

## Null

Null是所有AnyRef的子类，是所有继承了Object的类的子类，所以Null可以赋值给所有的引用类型(AnyRef)，不能赋值给值类型(AnyVal)，这个java的语义是相同的。null是Null的唯一对象。

```scala
val x = null         // x: Null
val y: String = null // y: String = null
val z: Int = null    // error: type mismatch
val u: Unit = null   // u: Unit = ()
```

注意，不要被Unit值类型在赋值时的障眼法给骗了，以为null可以被赋给Unit。实际上把任何表达式结果不是Unit类型的表达式赋给Unit类型变量，都被转为`{ expr; () }`，所以上面的等同于`{null; ()}`把最终得到的`()`赋给了`u`变量。


Null在类型推导时只能被造型为AnyRef分支下的类型，不能造型为AnyVal分支下的类型，不过我们显式的通过asInstanceOf操作却又是可以把null造型为AnyVal类型的:

```scala
val i = null.asInstanceOf[Int]
// 类似于java里的 int i = (int)((Integer)null);
```

先装箱`Int`为引用类型，`null`被造型成了引用类型的`Int(java.lang.Integer)`，然后又做了一次拆箱，把一个为`null`的`Integer`类型变量造型成`Int`值类型，但在拆箱这一点处理上，体现了scala与java的不同：

```scala
// java里，编译通过，运行失败，空指针异常
int i = (int)((Integer)null);

// scala里，把值为null的Integer拆箱为值类型Int是ok的，得到Int的默认值0
val i = null.asInstanceOf[java.lang.Integer].asInstanceOf[Int]
```
在java里基本类型(primitive type) 与引用类型是有明确差异的，虽然提供了自动装箱拆箱的便捷，但在类型上两者是不统一的；而scala里修正这一点，`Int`类型不再区分`int/Integer`，类型一致，所以值为`null`的`Integer`在通过`asInstanceOf[Int]`时被当作一个未初始化的`Int`对待，返回了一个默认值`Int`(注:`asInstanceOf`不改变原值，返回一个新值)。

## Nil

Nil是一个空的List，定义为`List[Nothing]`，根据List的定义`List[+A]`，所有Nil是所有`List[T]`的子类。




