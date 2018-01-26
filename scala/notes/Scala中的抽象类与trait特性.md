Scala中的抽象类与特征
===

抽象类
---

Scala的抽象类跟Java的一样，不能被实例化。其中一些特性也与Java的抽象类非常类似。

1. 定义抽象类需要使用abstract
2. 在抽象类中，变量不使用就无需初始化，可以等到子类继承时再进行初始化。
3. 在抽象类中，抽象方法无需使用（也不能）用abstract进行修饰。
    - 一个方法只要是没有它的实现（没有等号或没有方法体），它就是抽象的，在子类中覆写或者覆写接口中的非抽象方法（方法有具体实现）要使用override关键字。

```scala
object AbstractScala {  
    def main(args: Array[String]): Unit = {  
        val cat = new Cat("小小")  
        cat.cry  
    }  
}  
  
abstract class Animal(name:String){  
    var kind:String //抽象field  
    def cry //抽象方法  
}  
  
class Cat(name:String) extends Animal(name){  
    override var kind: String = "猫"  
    override def cry: Unit = println(kind + "["+name+"]" + "：喵！！")  
}  
```

### 抽象类型

Scala 中的类型成员也可以是抽象的。
比如，在Trait中，你可以让类型成员保持抽象。

```scala

trait Foo {
    type T;
    val x: T;
    def getX: T = x
}

println((new Foo{type T = Int; val x = 123}).getX)
println((new Foo{type T = String;val x = "hello tony"}).getX)

/*
123
hello tony 
*/

```

trait（特征）
---

trait的字面意思是特质或者特征。它的意义和java，c#中接口很类似，但java中（implement）接口方法是不能有具体的实现，同时接口也不能继承类，而scala的trait是能有具体实现也能被继承的类。


1. 继承这个trait就必须实现其中的抽象方法
2. 继承trait的类自动获得了trait中定义的field
    - 但是这种获取field的方式与继承class是不同的：如果是继承class获取的field，实际是定义在父类中的；而继承trait获取的field，就直接被添加到了类中
3. 可以在创建对象的时候继承特质，但是继承的特质需要和类继承的公共的祖先   
4. 同时继承多个trait的时候：
    - 父类的构造函数执行
    - 多个trait从左到右依次执行
    - 构造trait时会先构造父trait，如果多个trait继承同一个父trait，则父trait只会构造一次
    - 所有trait构造完毕之后，子类的构造函数执行 
*/ 

```scala
import java.util.Date

trait Logger {
    val time: Long = new Date().getTime
    val method: String //抽象字段  类在继承此trait时必须覆盖抽象time字段，提供具体的值
    def info(msg: String)

    def error(msg: String): Unit = {}

    def warning(msg: String): Unit = {}
}

trait ImpError extends Logger {
    override def error(msg: String) = println(time + "->>>" + method + "->>>" + msg)
}

trait ImWarning extends Logger {
    override def warning(msg: String) = println(time + "->>>" + method + "->>>" + msg)
}

class ConCreateLogger(m: String) extends Logger with Cloneable with ImWarning {
    val method: String = m //实现父类的抽象field
    def info(msg: String): Unit = println(time + "->>>" + method + "->>>" + msg)
}

object TraitScala {
    def main(args: Array[String]): Unit = {
        val log = new ConCreateLogger("hello")
        log.info("1")
        log.error("2")
        log.warning("3")

        val log2 = new ConCreateLogger("say") with ImpError
        log2.info("4")
        log2.error("5")
        log2.warning("6")
    }
}
/*
1516984736844->>>hello->>>1
1516984736844->>>hello->>>3
1516984737232->>>say->>>4
1516984737232->>>say->>>5
1516984737232->>>say->>>6
*/
```

### 在trait中覆盖抽象方法

在trait中，是可以覆盖父trait的抽象方法的。 
但是覆盖时，如果使用了super.方法的代码，则无法通过编译。因为super.方法就会去掉用父trait的抽象方法，此时子trait的该方法还是会被认为是抽象的。 
此时如果要通过编译，就得给子trait的方法加上abstract override修饰。

```scala
/**
  * 下面这个例子基于trait的AOP(Aspect-oriented programming)代码实战 
  * 也就是基于trait 调用链方式 
  */
trait DoAction {
    def action
}


trait AopBefore extends DoAction {
    /**
      * 在trait中，是可以覆盖父trait的抽象方法 
      * 但是如果方法体使用了super.方法的代码，则无法通过编译 
      * 因为super.方法就会去掉用父trait的抽象方法，此时子trait的该方法还是会被认为是抽象的 
      * 此时如果要通过编译，就得给子trait的方法加上abstract override修饰 
      */
    abstract override def action = {
        println("调用前执行-----------")
        super.action
        println("调用后执行-------------")
    }
}

class Work extends DoAction {
    override def action: Unit = println("Work!")
}

object TraitScala {
    def main(args: Array[String]): Unit = {

        //其实就是使用了trait调用链的特性  
        val w = new Work with AopBefore
        w.action
    }
}

/*
调用前执行-----------  
Work!  
调用后执行-------------  
*/
```

类中的apply()
---

在 Scala 的类中，apply() 可以看作是一个语法糖，它分为两种方式：object和class中的用法。

### 常见的 apply() 用法

借用一个经典的例子。

```scala
class Foo{}

object FooMaker {
    def apply() = new Foo
}

object Demo {
    def main(args: Array[String]): Unit = {
        val newFoo = FooMaker() 
        // 在调用 FooMaker() 时，触发了apply()，所以生成了一个新的Foo对象。
    }
}
```

```scala
class Bar {
    def apply(): Unit = println("this is bar")
}

object Demo {
    def main(args: Array[String]): Unit = {
        val bar = new Bar
        println(bar())
        bar()
        // 在调用bar()时，触发了apply()，打印了this is bar
    }
}

/*
this is bar
()
this is bar
*/
```

object类是单例，不能进行new的实例化。在调用类名()时，便会触发调用该object中的apply()。如果object类中没有apply()，这样调用会报错。

```scala

scala> object FooMarker2 {
     |   def apply2() = new Foo
     | }
defined object FooMarker2

scala> val newFoo2 = FooMarker2()
<console>:13: error: FooMarker2.type does not take parameters
       val newFoo2 = FooMarker2()

```

在类中，创建`val bar = new Bar`之后，调用`bar()`便会触发该类的`apply()`。同样，class中没有定义`apply()`，这样调用也是会报错的。

```scala
scala> class Bar2 {
     |   def apply2() = println("this is bar2")
     | }
defined class Bar2

scala> val bar2 = new Bar2
bar2: Bar2 = Bar2@7f416310

scala> bar2()
<console>:14: error: Bar2 does not take parameters
       bar2()
           ^
```

### 伴生类和伴生对象中的apply()

```scala
class ApplyTest {

  def apply() = println("This is called by class!")

  def haveATry: Unit = {
    println("have a try on apply")
  }
}

object ApplyTest {

  def apply() = {
    println("This is called by companion object")
    new ApplyTest
  }
}

object ApplyOperation {
  def main(args: Array[String]) {

    val a1 = ApplyTest()   //object 的 apply() 使用

    a1.haveATry
    a1() // class 中 apply()使用

    println("------------------")

    val a2 = new ApplyTest
    a2.haveATry
    a2() // class 中 apply()使用
  }
}

/*
This is called by companion object
have a try on apply
This is called by class!
------------------
have a try on apply
This is called by class!
*/
```

最后，除了在类中可以使用apply()，在function中也可以使用apply()，因为在 Scala 中函数即对象，后面的笔记会进行总结。

类中的update()
---

`update()`也可以看作是 Scala 的语法糖。
使用` update() `时，等号右边的值会作为update方法的最后一个参数。

```
class User(var name:String,var password:String) {
    def update(name:String,password:String): Unit = {
        println(s"changing use of $name and $password")
        this.name = name
        this.password = password
    }
}

object Demo {
    def main(args: Array[String]): Unit = {
        val tony = new User("tony","123456")
        println(tony.password)
        tony.update("tony","abcdefg")
        println(tony.password)
        tony("tony") = "123456"
        println(tony.password)
    }
}

/*
123456
changing use of tony and abcdefg
abcdefg
changing use of tony and 123456
123456
*/
```

在这里，tony.update("tony","abcdefg") 和 tony("tony") = "abcdefg" 这两句话是等价的。前一种方法比较中规中矩，后一种方法更加简洁。

参考资料
---

1. [scala入门教程：scala中的trait](http://outofmemory.cn/scala/scala-trait-introduce-and-example)
2. [Scala之trait](http://blog.csdn.net/echo_ale/article/details/72205756)
3. [scala学习笔记(八):抽象类、trait特性](http://gbjian001.iteye.com/blog/2346692)