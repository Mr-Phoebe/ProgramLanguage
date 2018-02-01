scala中的classOf、isInstanceOf、asInstanceOf
===

Scala的三个预定义(predefined)方法，我们经常用到。

```scala
object PredefineTest{  
  def main(args: Array[String]): Unit = {  
    val c : Char = 97.asInstanceOf[Char]  
    "hello".asInstanceOf[String]  
    1.asInstanceOf[Long]  
    val it: Seq[String] = List("a", "b")  
    it.asInstanceOf[List[String]]  
  
    "hello".isInstanceOf[String]  
  
    classOf[String]  
    /*
    val c : Char = 97.asInstanceOf[Char]
    println("hello".asInstanceOf[String])
    println(1.asInstanceOf[Long])
    val it: Seq[String] = List("a", "b")
    println(it.asInstanceOf[List[String]])
    println("hello".isInstanceOf[String])
    println(classOf[String])
    hello
    1
    List(a, b)
    true
    class java.lang.String
    */
  }  
}  
```

使用`scalac -Xprint:cleanup PredefineTest.scala`，Scala编译器输出的main方法体内代码的抽象语法树（AST）信息如下：

```
val c: Char = 97.toChar();  
("hello": java.lang.String);  
1.toLong();  
val it: Seq = immutable.this.List.apply(scala.this.Predef.wrapRefArray(Array[java.lang.String]{"a", "b"}.$asInstanceOf[Array[java.lang.Object]]()));  
it.$asInstanceOf[List]();  
"hello".$isInstanceOf[java.lang.String]();  
{  
  classOf[java.lang.String];  
  ()  
}  
```

使用jd反编译工具查看对应代码如下：

```
char c = (char)97;  
"hello";  
1;  
Seq it = List..MODULE$.apply(Predef..MODULE$.wrapRefArray((Object[])new String[] { "a", "b" }));  
((List)it);  
  
("hello" instanceof String);  
String.class;  
```

classOf[T]
---

获取类型T的Class对象。

classOf方法定义在`scala.Predef object`:

```scala
object Predef extends LowPriorityImplicits {  
      /** Return the runtime representation of a class type.  This is a stub method.  
       *  The actual implementation is filled in by the compiler.  
       */  
      def classOf[T]: Class[T] = null  
    ...  
}
```

classOf的注释翻译过来的意思是：返回在运行过程中的类型。这是一个存根方法。具体的实现是由编译器填补（自动生成）。

`Predef object`是默认导入的，所以classOf方法相当于一个全局方法。

isInstanceOf[T]
---
 
判断对象是否为T类型的实例。

`isInstanceOf`和`asInstanceOf`由scala.Any类定义，所以所有对象都自动拥有isInstanceOf和asInstanceOf这两个方法。

再看一下例子:

```scala
scala> 1.isInstanceOf[String]  
res0: false  
  
scala> List(1).isInstanceOf[List[String]]  
res0: true 
```

由于Scala像Java一样泛型存在类型擦除的原因，`List(1).isInstanceOf[List[String]]`及相当于`List(1).isInstanceOf[List[_]]`, List(1)是List的实例。这样的问题在模式匹配的时候也会遇到，关于如何克服类似的问题，可以参见[scala中的类型擦除的问题](http://blog.csdn.net/u013007900/article/details/79223519)


asInstanceOf[T]
---

将对象类型强制转换为T类型。

还是由于泛型存在类型擦除的原因，`1.asInstanceOf[String]`在运行时会抛出ClassCastException异常，而`List(1).asInstanceOf[List[String]]`将不会。

在scala 讨论组里有人问道[这样一个问题](http://scala-programming-language.1934581.n4.nabble.com/isInstanceOf-question-td1938141.html)：

```
“I expect "new AnyRef().isInstanceOf[AnyVal]" to be false, but I get true instead”
scala> new AnyRef().isInstanceOf[AnyVal]
res0: Boolean = true
```

大家有兴趣看以看看后面的解答，不过试了scala 2.9，这种用法已经被编译器禁止了：
 
```
scala> new AnyRef().isInstanceOf[AnyVal]
<console>:8: error: type AnyVal cannot be used in a type pattern or isInstanceOf test
new AnyRef().isInstanceOf[AnyVal]
```

还有，值得提一下的一个小细节就是，通过观察编译输出的AST,  知道对于在基本类型如Int等的对象上调用`asInstanceOf[T]`, Scala会将其转换为调用相应的`toT`方法, 如 `97.asInstanceOf[Char]`, 就会转换为`97.toChar`, 其中`toChar`定义在scala.Int:

```scala
final class Int extends AnyVal {  
  ...  
  def toChar: Char = sys.error("stub")  
  ...  
} 
```

而后， Scala编译器会进一步将其编译成与“(char)97”相同的字节码。

结论
---

总而言之，我们把`classOf[T]`看成Java里的`T.class`, `obj.isInstanceOf[T]`看成 `obj instanceof T`, `obj.asInstanceOf[T]`看成`(T)obj`就对了。

但是同样也要注意类型擦除造成的问题。









