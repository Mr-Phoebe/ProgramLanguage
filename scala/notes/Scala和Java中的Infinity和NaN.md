Scala和Java中的Infinity和NaN
=

Infinity
---

`i == i + 1`，一个数字永远不会等于它自己加1？

Java强制要求使用IEEE 754浮点数算术运算，它可以让你用一个double或float来表示无穷大。正如我们在学校里面学到的，无穷大加1还是无穷大。

你可以用任何被计算为无穷大的浮点算术表达式来初始化`i`，例如：


```Java
double i = 1.0 / 0.0;
```
不过，你最好是能够利用标准类库为你提供的常量：


```java
double i = Double.POSITIVE_INFINITY;
```

事实上，很多情况下都不需要真正使用无限大来表示无限大，许多足够大的浮点数都可以实现这一目的，例如：

```java
double i = 1.0e40;
```

同时Java和Scala提供了一些检测方法：

```Java
Double.isInfinite();
Double.isFinite();
```

```scala
scala> val a = 22.0
a: Double = 22.0

scala> a.isInfinite
res0: Boolean = false

scala> val b = 2.0/0
b: Double = Infinity

scala> b.isInfinite
res1: Boolean = true

scala> b.isPosInfinity
res4: Boolean = true
```

NaN
---

`i==i`，一个数字总是等于它自己? 

IEEE 754浮点算术保留了一个特殊的值用来表示一个不是数字的数量。这个值就是NaN（Not a Number），对于所有没有良好的数字定义的浮点计算，例如`0.0/0.0`，其值都是它。规范中描述道，**NaN不等于任何浮点数值，包括它自身在内**。

你可以用任何计算结果为NaN的浮点算术表达式来初始化i，例如：

```java
double i = 0.0 / 0.0;
```

同样，为了表达清晰，你可以使用标准类库提供的常量：

```java
double i = Double.NaN;
```

NaN还有其他的惊人之处。


```java
Double.NaN == Double.NaN //结果是false。但是，
Double a = new Double(Double.NaN);
Double b = new Double(Double.NaN);]
a.equals(b);  //true
```

任何浮点操作，只要它的一个或多个操作数为NaN，那么其结果为NaN。这条规则是非常合理的，但是它却具有奇怪的结果。例如，下面的程序将打印false：

```java
class Test {

    public static void main(String[] args) {
        double i = 0.0 / 0.0;
        System.out.println(i - i == 0);
    }
}

```
总之，float 和double 类型都有一个特殊的NaN 值，用来表示不是数字的数量。


同时Java和Scala提供了一些检测方法：

```Java
Double.isInfinite();
Double.isFinite();
```

```scala
scala> val a = 22.0
a: Double = 22.0

scala> a.isInfinite
res0: Boolean = false

scala> val b = 2.0/0
b: Double = Infinity

scala> b.isInfinite
res1: Boolean = true

scala> b.isPosInfinity
res4: Boolean = true
```

NaN
---

`i==i`，一个数字总是等于它自己? 

IEEE 754浮点算术保留了一个特殊的值用来表示一个不是数字的数量。这个值就是NaN（Not a Number），对于所有没有良好的数字定义的浮点计算，例如`0.0/0.0`，其值都是它。规范中描述道，**NaN不等于任何浮点数值，包括它自身在内**。

你可以用任何计算结果为NaN的浮点算术表达式来初始化i，例如：

```java
double i = 0.0 / 0.0;
```

同样，为了表达清晰，你可以使用标准类库提供的常量：

```java
double i = Double.NaN;
```

NaN还有其他的惊人之处。


```java
Double.NaN == Double.NaN //结果是false。但是，
Double a = new Double(Double.NaN);
Double b = new Double(Double.NaN);]
a.equals(b);  //true
```

任何浮点操作，只要它的一个或多个操作数为NaN，那么其结果为NaN。这条规则是非常合理的，但是它却具有奇怪的结果。例如，下面的程序将打印false：

```java
class Test {

    public static void main(String[] args) {
        double i = 0.0 / 0.0;
        System.out.println(i - i == 0);
    }
}

```
总之，float 和double 类型都有一个特殊的NaN 值，用来表示不是数字的数量。


同时Java和Scala提供了一些检测方法：

```Java
Double.isNaN();
```

```scala
scala> val a = 22.0
a: Double = 22.0

scala> a.isNaN
res0: Boolean = false

scala> val b = 0.0/0
b: Double = NaN

scala> a.isNaN
res1: Boolean = true
```


