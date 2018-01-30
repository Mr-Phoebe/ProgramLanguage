Scala中的泛型编程
===

简介
--

在Java或者C++里面，像列表（`List`）这些数据结构，在编写的时候，都不需要指定其中元素的类型，而是构造的时候指定，这一特性就称为泛型。同样，Scala中也提供了泛型，而且功能比Java的泛型更加强大。

```java
List<String> strList = new ArrayList<String>();
strList.add("one");
strList.add("two");
strList.add("three");

String one = strList.get(0); 
// 泛型拿数据不必进行类型转换，不使用泛型的话需要对类型进行转换
```

类型参数化(type parameterlization)
---

scala中的泛型称为类型参数化(type parameterlization)。语法跟java不一样，使用`[]`表示类型。

### 方法的泛型

一个使用类型参数化的方法：

```scala
def position[A](xs: List[A], value: A): Int = {
    xs.indexOf(value)
}

position(List(1,2,3), 1) // 0
position(List("one", "two", "three"), "two") // 1
```

稍微复杂点的类型参数化，实现一个map函数，需要一个List和一个函数作为参数：

普通的map方法：

```scala
List(1,2,3) map { _ * 2 }  // List[Int] = List(2,4,6)
List(1,2,3) map { _ + "2" }  // List[String] = List(12, 22, 32)
```

使用泛型实现的map方法：

```scala
def map[A, B](list:List[A], func: A => B) = list.map(func)

map(List(1,2,3), { num: Int => num + "2" }) // List[String] = List(12, 22, 32)
map(List(1,2,3), { num: Int => num * 2 }) // List[Int] = List(2, 4, 6) 
```

### 类的泛型

可以给一个类添加泛型，这样，在编写的时候就不需要考虑这一类型的具体情况，而是使用一个标记来注明。

```scala
class Pair[K, V] (val key: K, val value: V)
```

类似构造函数，如果要继承的类包括泛型，那么继承时也需要写泛型的类型：

```scala
class SimplePair[T] (key: T, value: T) extends Pair[T, T](key, value)
```

不过这里Pair的泛型其实是可以通过构造函数传值的类型猜测出来的，所以可以省略：

```scala
class SimplePair[T] (key: T, value: T) extends Pair(key, value)
```

这样，类名在声明或者新建实例的时候也需要写明泛型的类型：

```scala
val p1: Pair[Int, String] = new Pair[Int, String](1, "abc")
val p2 = new Pair(1, "abc") //可以猜到的类型和泛型设定都被省略掉了
```
泛型的上下界
---

在定义泛型列表的时候可以使用`<:`和`>:`规定泛型元素的上下界：

```scala
class A
class B extends A
class C extends B
class D extends C
class E extends D

class T1[T >: B]
class T2[T <: B]
class T3[T >: D <: B]
class T4[T <: B with Ordered[T]]    // 可以使用with关键字对多个特征进行限定
                                    // 在继承B的同时还要求有可排序的性质

new T1[A]
//new T1[C] 不能通过编译

//new T2[A] 不能通过编译
new T2[C]

//new T3[A] 不能通过编译
new T3[B]
new T3[C]
new T3[D]
//new T3[E] 不能通过编译

def upperBound[A <: Animal](list: ListBuffer[A]): Unit = { 
    list += new Animal("123")   // compile error
    val obj: AnyRef = list(0)   // ok
    val a1: Animal = list(0)    // ok
    val a2: Cat = list(0)       // compile error
} 

def lowerBound[A >: Animal](list: ListBuffer[A]): Unit = { 
    list += new Animal()        // ok
    list += new Cat()           // ok
    val obj1: Any = list(0)     // ok
    val obj2: Animal = list(0)  // compile error
}
```

可以对比一下Java的使用

```Java
public void upperBound(List<? extends Number> l) {
    Object obj = l.get(0); // Number是Object的子类，使用Object可以代替Number。
    Number num = l.get(0);
    Integet i = l.get(0); // compile error
    l.add(new Integer(1)); // compile error
}

public static void lowerBound(List<? super Number> l) {
    l.add(new Integer(1));
    l.add(new Float(2));
    Object obj = l.get(0);
    Number num = l.get(0); // compile error
}
```

协变和逆变
---

协变(covariance)：对于一个带类型参数的类型，比如`List[T]`，如果对A及其子类型B，满足`List[B]`也符合`List[A]`的子类型，那么就称为协变，用加号表示。比如 `MyType[+A]`。

逆变(contravariance)：如果`List[A]`是`List[B]`的子类型，用减号表示。比如`MyType[+B]`。

如果一个类型支持协变或逆变，则称这个类型为可变的(variance)，否则称为不可变的(invariant)。在java里，泛型类型都是不可变的，比如`List<String>`并不是`List<Object>`的子类。

```scala
trait A[T]
class C[T] extends A[T]
class Parent; class Child extends Parent
val c1:C[Parent] = new C[Parent] // ok
val c2:C[Parent] = new C[Child] // error, Child <: Parent, but class C is invariant in type T.
```

### 协变

上面的例子提示已经很明确了。类C是不可变的，改成协变即可。

```scala
trait A[+T]
class C[+T] extends A[T]
class Parent; class Child extends Parent
val c1: C[Parent] = new C[Parent] // ok
val c2: C[Parent] = new C[Child]  // ok
```

scala中List就是一个协变类。

```scala
val list:List[Parent] = List[Child](new Child())
```

### 逆变

逆变概念与协变相反。

```scala
trait A[-T]
class C[-T] extends A[T]
class Parent; class Child extends Parent
val c: C[Parent] = new C[Parent] // ok
val c: C[Child] = new C[Parent]  // ok
```

### 协变逆变注意点

逆变协变并不会被继承，父类声明为逆变或协变，子类如果想要保持，任需要声明：

```scala
trait A[+T]
class C[T] extends A[T] // C是不可变的，因为它不是逆变或协变。
class D[+T] extends A[T] // D是可变的，是协变
class E[-T] extends A[T] // E是可变的，是逆变
```

参考资料
---

1. [Java-泛型编程-类型擦除(Type Erasure)](http://blog.csdn.net/fw0124/article/details/42295463)
2. [【Scala类型系统】类型参数化和变化型注解](https://www.jianshu.com/p/ca8867dcbde0)
3. [[译]Scala泛型类](https://www.jianshu.com/p/6d1050d73e19)