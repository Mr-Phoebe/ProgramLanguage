Scala中的override
===

override是覆盖的意思，在很多语言中都有，在scala中，override是非常常见的。

在类继承方面，它和java不一样，不是可写可不写的了，而**是必须写**的。如果不写而覆盖了对应的属性或者方法的话，编译器就会报错了。

基础用法
---


```scala
/*
基本的override特性
*/
object Testclass {
    class A {
        val nameVal = "A"
        var nameVar = "A"

        def foo: String = {
            "A.foo"
        }
    }

    class B extends A {
        override val nameVal = "B"
        //override var nameVar = "B"  "variable nameVar cannot override a mutable variable"
        override def foo: String = {
            "B.foo"
        }
    }

    def main(args: Array[String]): Unit = {
        val b1 = new B
        println(b1.foo)
        println(b1.nameVal)
        println(b1.nameVar)
        val b2 : A = new B
        println(b2.foo)
        println(b2.nameVal)
        b2.nameVar = "B"
        println(b2.nameVar)
    }
}

/*
B.foo
B
A
B.foo
B
B
*/
```

当一个类extends另外一个类的时候，override的规则基本如下：

1. 子类中的方法要覆盖父类中的方法，必须写override（参见foo）
2. 子类中的属性val要覆盖父类中的属性，必须写override（参见nameVal）
3. 父类中的变量不可以覆盖（参见nameVar）

抽象类
---
在抽象类中可以不用写override

```scala

object Testclass {
/*
trait的extent不需要override
*/
    trait T {
        def foo : String
        def bar : String
    }

    class TB extends T {
        def foo: String = {
            "TB.foo"
        }

        def bar: String = "TB.bar"
    }

    trait TT  extends T {
        def bar :String = "TT.bar"
    }

    class TTB extends TT {
        def foo: String = "TTB.foo"
    }

    def main(args: Array[String]): Unit = {
        val tb = new TB
        println(tb.foo)
        println(tb.bar)
        val ttb = new TTB
        println(ttb.foo)
        println(ttb.bar)
    }
}
/*
TB.foo
TB.bar
TTB.foo
TT.bar
*/
```

T是特性类，它定义了两个抽象方法，foo和bar。TB的类继承和实现了T特性类，这个时候，TB类中的foo和bar前面的override是可写可不写的。

这里初步看下TB类中的foo和bar前面的override写和不写感觉都一样，但是一旦有**钻石结构**的类继承，这个override的作用就体现出来了。这个我们后续说。

TT和TTB的例子也是说明了下trait继承trait是不需要使用override的。

```scala
/*
abstrct class 不需要override
*/
object Testclass {
    abstract class PA(name: String) {
        def hello: String
    }
    class PB(name: String) extends PA(name) {
        def hello : String = s"hello ${name}"
    }

    def main(args: Array[String]): Unit = {
        val pb = new PB("sujing")
        println(pb.hello)
    }
}
/*
hello sujing
*/
```

abstract class和trait的特性主要是在是否有构造参数，在override方面都是一样的。

钻石结构
---

所谓的钻石结构就是一个菱形的结构，一个基类，两个子类，最后一个类又继承这两个子类。那么如果这两个子类都包含一个基类的方法，那么最后的这个类也有这个方法，选择继承那个子类呢？

```scala
/*
diamond problem
*/
object Testclass {
    trait Animal {
        def talk: String
    }
    trait Cat extends Animal {
        def talk: String = "I am Cat"
    }
    trait Monkey extends Animal {
        def talk: String = "I am monkey"
    }
    trait Dog extends Animal {
        override def talk: String = "I am Dog"
    }

    class MonkeyCat extends Monkey with Cat {
        override def talk: String = "I am monkeyCat"
    }

    def main(args: Array[String]): Unit = {
        val kittyDog = new Cat with Dog
        println(kittyDog.talk)
        val monkeyCat = new MonkeyCat
        println(monkeyCat.talk)
    }
}
/*
I am Dog
I am monkeyCat
*/
```

在这个例子中，Animal是基类，Cat和Dog是子类，kittyDog是继承了Cat和Dog，那么kittyDog里面的talk使用的是Cat和Dog中有标示override的那个方法。这个时候override的作用就体现出来了。

参数复写使用override
---

我们可以直接在构造函数里面使用override重写父类中的一个属性。我理解这个更多是语法糖的一个功能。

```scala
/*
diamond problem
*/
object Testclass {
/*
parameter override
*/
    class Person(val age : Int){
        val name = "no name"
    }

    class XiaoMing(age: Int, override val name: String) extends Person(age){

    }
    
    def main(args: Array[String]): Unit = {
        val xiaoming = new XiaoMing(12, "xiaoming")
        println(xiaoming.name)
    }
}
/*
xiaoming
*/
```


