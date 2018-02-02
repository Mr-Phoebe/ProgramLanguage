Scala中的模式匹配
===

前言
---

模式匹配是一种scala中的一种函数式编程概念，也常常用于OOP中的一些多态实现，跟java、C++中的switch case或者正则表达式神似，但是试用范围更广。

大家需要记住的是：**Scala的模式匹配发生在但绝不仅限于发生在match case语句块中，这是Scala模式匹配之所以重要且有用的一个关键因素！**

match表达式
---

1. match表达式始终以值作为结果，这是Scala表达式的特点
2. Scala的备选项表达式永远不会意外掉入到下一个分支。在C或其他类C语言中，每个分支末尾要显式使用break语句来退出switch。
3. 如果没有模式匹配，MatchError异常会被抛出。这意味着你必须始终确信所有的情况都考虑到，或者至少意味着可以添加一个默认情况什么事都不做

一个简单的例子

```scala
object ConstantPattern{
  def main(args: Array[String]): Unit = {
    def patternShow(x:Any)=x match {
      case 5 => "five"
      case true=>"true"
      case "test"=>"String"
      case _  =>"Other constant"    // default
    }    
    println(patternShow(5))
  }
}
```

模式匹配类型
---

在Scala中一共有如下几种类型的模式匹配：

1. 常量匹配 （Constant Pattern Matching ）
2. 变量匹配（Variable Pattern Matching ）
3. 通配符匹配（Wildcard Pattern Matching ）
4. 构造函数匹配（Constructor Pattern Matching ）
5. 集合类型匹配（Sequence Pattern Matching ）
6. 元祖类型匹配（Tuple Pattern Matching ）
7. 类型匹配（Typed Pattern Matching ）

### 常量匹配

常量匹配仅匹配自身，包含常量变量和常量字面量 

```scala
object ConstantPattern {
  def main(args: Array[String]): Unit = {
        val Six = 6 //注意这里常量必须以大写字母开头
        println(patternShow(6))
        def patternShow(x:Any) = x match {
            case 5 => "five"
            case Six => "six"
            case true => "true"
            case "test"=>"String"
            case null=>"null"
            case Nil=>"empty list"
            case _  =>"Other constant"
        }
    }
}
```

### 变量模式

确切的说单纯的变量模式没有匹配判断的过程，它可以匹配任意对象。匹配只是把传入的对象给起了一个新的变量名，新的变量名就是匹配的对象。

```scala
object VariablePattern {
    def main(args: Array[String]): Unit = {
        def patternShow(x: Any) = x match {
            case 5 => println("five")
            //所有不是值为5的都会匹配变量y
            //例如"xxx"，则函数的返回结果就是"xxx"
            case y => println(y)
        }
        var x = 6
        patternShow(x)
    }
}
```

上面把要匹配的x对象用y变量名代替，所以它总会匹配成功。

不过这里有个约定，**对于变量，要求必须是以小写字母开头，否则会把它对待成一个常量变量**，比如上面的`y`如果写成`Y`就会去找这个`Y`的变量，如果找到则比较相等性，找不到则出错。

```scala
object VariablePattern {
  def main(args: Array[String]): Unit = {
        def patternShow(x: Any) = x match {
            case 5 => "five"
            case Six => "six"   // error
        }
        println(patternShow(6))
    }
}
```

变量模式通常不会单独使用，而是在多种模式组合时使用，比如

```scala
List(1,2) match{ case List(y,2) => println(y) }
```

里面的x就是对匹配到的第一个元素用变量x标记。

### 通配符模式

通配符用下划线表示："_" ，可以理解成一个特殊的变量或占位符。

单纯的通配符模式通常在模式匹配的最后一行出现，case _ => 它可以匹配任何对象，用于处理所有其它匹配不成功的情况。

通配符模式也常和其他模式组合使用：

```scala
object WildcardPattern {
    def main(args: Array[String]): Unit = {
        def patternShow(x: Any) = x match {
            case List(0, _, _) => "a three-element list with 0 as the first element"
            case List(1, _*) => "a list beginning with 1, having any number of elements"
            case Vector(1, _*) => "a vector starting with 1, having any number of elements"
            case list: List[_] => s"thanks for the List: $list"
            case m: Map[_, _] => m.toString
            // the default wildcard pattern
            case _ => "Unknown"
        }
        println(patternShow(List(0,1,2)))
        println(patternShow(List(1,2)))
        println(patternShow(List(1,2,3)))
        println(patternShow(Vector(1,2,3)))
        println(patternShow(List("apple", "banana")))
        println(patternShow(Map(1->"Al", 2->"Alexander")))
    }
}
/*
a three-element list with 0 as the first element
a list beginning with 1, having any number of elements
a list beginning with 1, having any number of elements
a vector starting with 1, having any number of elements
thanks for the List: List(apple, banana)
Map(1 -> Al, 2 -> Alexander)
*/
```

### 构造器模式

构造器模式提供了深度匹配(deep match)，如果备选项是样本类，那么构造器模式首先检查对象是否为该备选项的样本类实例，然后检查对象的构造器参数是否符合额外提供的模式。 

构造器模式不只检查顶层对象是否一致，还会检查对象的内容是否匹配内层的模式。由于额外的模式自身可以形成构造器模式，因此可以使用它们检查到对象内部的任意深度。

```scala
object ConstructorPattern {
    abstract class Item
    case class Product(description: String, price: Double) extends Item
    case class Bundle(description: String, discount: Double, items: Item*) extends Item

    def main(args: Array[String]): Unit = {
        def price(it: Item): Double = it match {
            case Product(_, p) => p
            case Bundle(_, disc, its @ _*) => its.map(price _).sum * (100-disc) /100
            //这里@表示将嵌套的值绑定到变量its
            // 这里使用了price作为匿名函数，和map(price(_))等价
        }
        val bun1 = Bundle("Father's day special", 20.0, Product("Massager", 188.0))
        val bun2 = Bundle("Appliances on sale", 10.0, Product("Haier Refrigerato", 3000.0), Product("Geli air conditionor",2000.0))
        println(price(bun1))
        println(price(bun2))
    }
}
/*
150.4
4500.0
*/
```

再来看一个例子

我们来定义一个二叉树，并构造一个根节点含有2个子节点的树。

如果我们期望一个树的构成是根节点的左子节点值为”left”，右子节点值为”right”并且右子节点没有子节点，那么可以用下面的方式匹配：

```scala
object Demo {
    //抽象节点
    trait Node
    //具体的节点实现，有两个子节点
    case class TreeNode(v:String, left:Node, right:Node) extends Node
    //Tree，构造参数是根节点
    case class Tree(root:TreeNode)

    def main(args: Array[String]): Unit = {
        def patternShow(t: Any): Unit = t match {
            case TreeNode(_, TreeNode("left", _, _), TreeNode("right", null, null)) => println("bingo")
            case _ => println("error")
        }
        val tree = Tree(TreeNode("root",TreeNode("left",null,null),TreeNode("right",null,null)))
        patternShow(tree.root)
    }
}
```

这样才体现出了模式匹配的强大威力。

### 序列模式 

序列模式指的是像Array、List这样的SeqFactory的子类进行模式匹配，它其实就是抽取器模式。

看着与构造器模式一模一样，但是他们背后实现有所不同，所以在模式的表现形式上，不适合把它划为一类。

```scala
object SequencePattern {
  def main(args: Array[String]): Unit = {
        val p = List("spark", "hive", "SparkSQL", "pig")
        def sequencePattern(p:List[String])=p match {
            case List(_,second,_*) => second
            case _ => "Other"
        }
        println(sequencePattern(p))
    }
}
```

### 元组模式

```scala
object TuplePattern {
    def main(args: Array[String]): Unit = {
        val t = ("spark","hive","SparkSQL")
        def tuplePattern(t: Any) = t match {
            case (one, _, _) => one
            case _ => "Other"
        }
        println(tuplePattern(t))
    }
}
```

### 类型模式

类型模式很简单，就是判断对象是否是某种类型：

```scala
object TypePattern {
      def main(args: Array[String]): Unit = {
        def tuplePattern(t: Any) = t match {
            case t: String => "String"
            case t: Int => "Integer"
            case t: Double => "Double"
            case t: List[String] => "List[String]"
        }
        def tuplePattern2(t: Any) = { // 用上一篇文章的知识也能解决
            if(t.isInstanceOf[String]) "String"
            else if(t.isInstanceOf[Int]) "Int"
            else if(t.isInstanceOf[Double]) "Double"
            else if(t.isInstanceOf[Map[_,_]]) "MAP"
        }
        println(tuplePattern(5.0))
    }
}
```

如果使用了泛型，它会被擦拭掉，如同java的做法，所以上面的` List[String] `里的String运行时并不能检测
`foo(List("A"))` 和 `foo(List(2))` 都可以匹配成功。

实际上上面的语句编译时就会给出警告，但并不出错。
通常对于泛型直接用通配符替代，上面的写为 `case a : List[_] => …`

### 变量绑定模式

```scala
object VariableBindingPattern {
  def main(args: Array[String]): Unit = {
       var t=List(List(1,2,3),List(2,3,4))      
       def variableBindingPattern(t:Any)= t match {
         //变量绑定，采用变量名（这里是e)
         //与@符号，如果后面的模式匹配成功，则将
         //整体匹配结果作为返回
         case List(_, e@List(_, _, _)) => e
         case _ => Nil
       }

       println(variableBindingPattern(t))
  }
}
//编译执行后的输出结果为  List(2, 3, 4)
```

模式匹配的附加约束（Guard）
---

上述7种模式匹配是语法层面上的模式匹配，很多时候，只有这7种模式匹配是不够的，程序员需要根据具体的值做更细致的匹配，这时，我们需要对模式匹配附加更多的约束条件，这些约束条件叫做Guard，对应到代码上就是在case后面再添加if语句用于对匹配做更加细致的描述。让我们来看一个例子：

```
def testPatternGuard(x: (Int,Int)):Int = x match {
    case (a,a)=>a*2
    case (a,b)=>a+b
}

/*
error: a is already defined as value a
       case (a,a)=>a*2
               ^
*/               
```

上述代码的设计初衷是希望通过模式匹配来判断二元元组中的两个值是不是一样，如果是一样的，使用一种计算逻辑，如果不一样则使用另一个计算逻辑，但是这段代码是不能编译通过的，Scala要求“模式必须是线性的”，也就是说：模式中的变量只能出现一次。

在这个例子中寄希望使用一个变量让Scala在编译时帮助你判断两个值是否一值显然是做不到的，所以必然会报错，在这种场合就是需要使用if语句来限定匹配条件的时候了，以下正确的做法:

```scala
def testPatternGuard(x: (Int,Int)):String = x match {
    case (a,b) if a==b =>s"a==b,so, we can calc it as: a*2=${a*2}"
    case (a,b)=>s"a!=b,just calc it as: a+b=${a+b}"
}

println(testPatternGuard((1,2)))
println(testPatternGuard((1,1)))

```

样本类
---

带有case修饰符的类称为样本类(case class)。这种修饰符可以让Scala编译器自动为你的类添加一些句法上的便捷性。

1. 样本类会添加与类名一致的工厂方法。你不用new关键字就可以创建这个类。
2. 样本类参数列表中的所有参数隐式获得val前缀，因此它被当做字段维护。
3. 编译器为样本类添加了方法toString、hashCode和equals的实现。

这些便捷性的代价就是必须写case修饰符并且样本类和对象都因为附加的方法及对于每个构造器参数添加了隐含的字段而变得大了一点。 

样本类是一种特殊的类，它经过优化以被用于模式匹配。

封闭类
---

如果一个类被声明为sealed，则除了在定义这个class的文件内你可以创建它的子类之外，其他任何地方都不允许一个类去继承这个类。

在进行模式匹配时，我们需要时刻留心你的case语句是否能cover所有可能的情形，但如果在匹配一个类族（特别是子类）时，可能会出现无法控制的情况。因为如果类族是可以自由向下派生的话，过去覆盖了各种情形的case语句就可能不再“全面”了。

为了阻止这个事情的发生，你需要将样本类的通用超类声明为sealed。如果你使用继承自封闭类的样本类做匹配，编译器将通过通知警告信息标识出缺失的模式组合。 

举个例子：

```scala
sealed abstract class Amount

case class Dollar(value: Double) extends Amount
case class Euro(value: Double) extends Amount
case class Currency(value: Double, unit: String) extends Amount

def describe(a: Amount): String = a match {
    case Dollar(_) => "Dollar"
    case Euro(_) => "Euro"
}

//这里会出现编译器警告
//warning: match may not be exhaustive.
//It would fail on the following input: Currency(_, _)
//       def describe(a: Amount): String = a match {
//                                         ^
//describe: (a: Amount)String

```

如果想要让编译器不进行警告提示的话，需要给匹配的选择器表达式添加`@unchecked`注解。 
像是这样`def describe(a: Amount): String = (a: @unchecked) match {`。 

如果某个类是封闭的，那么在编译器所有子类就是可知的，因而编译器可以检查模式语句的完整性。让所有(同一组)样本类都扩展某个封闭类或特质是个好的做法。

Option类型
---

标准类库中的Option类型用样本类来表示那种可能存在、也可能不存在的值。Option类型有两个子类，分别是Some和None（单例对象），Some(value)的value是实际的值；None对象代表缺失的值。 

Scala集合类的某些标准操作会产生可选值。

例如Scala的Map的get方法会发现了指定键的情况下产生Some(value)，在没有找到指定键的时候产生None。 

举例如下：

```scala
object OptionDemo extends App{
  val m=Map("hive"->2,"spark"->3,"Spark MLlib"->4)

  def mapPattern(t:String)=m.get(t) match {
    case Some(x) => println(x);x
    case None => println("None");-1
  }

  println(mapPattern("Hive"))
}
//输出结果为：
//None
//-1
```

样本类None的形式比空字符串的意图更加清晰，比使用null来表示缺少某值的做法更加安全。 
Option支持泛型。举例来说，Some(Paris)的类型为Option[String]。

分离可选值最通用的办法是通过模式匹配的方式，举例如下：

```scala
scala> def showCapital(x: Option[String]) = x match {
     |   case Some(s) => s
     |   case None => "?"
     | }
showCapital: (x: Option[String])String

scala> showCapital(capitals get "Japan")
res5: String = Tokyo

scala> showCapital(capitals get "France")
res6: String = Paris

scala> showCapital(capitals get "China")
res7: String = Beijing

scala> showCapital(capitals get "North Pole")
res8: String = ?
```

Scala鼓励对Option的使用以说明值是可选的。这种处理可选值的方式有若干超越Java的优点。

1. Option[String]类型的变量是可选的String，这比String类型的变量或可能有时是null来说更加明显
2. 使用可能为null而没有检查是否为null的变量产生的编程错误在Scala里变为类型错误，即如果变量是Option[String]类型的，而你打算当做String使用，这样不会编译通过。

模式匹配无处不在
---

上面我们演示的所有模式匹配都是基于match case语句块的，诚如我们在文章一开始就强调的：如果模式匹配仅仅存在于match case语句中，那这项优秀特性的辐射的能量将会大打折扣，Scala正是将模式匹配发扬到编程的方方面面，才使得模式匹配在Scala里真正地大放异彩。

其实很多时候你用了这些方法，但是可能意识不到这是基于模式匹配的。

### 变量定义中的模式匹配

这可能是Scala的模式匹配最吸引人的地方了，在Scala里，每当你定义一个变量时，你可以直接利用模式匹配同时为多个变量一次性赋值！这一特性被广泛使用于从元组，Case类和构造器中提取对应的值赋给多个变量。以下展示了几种常见的示例：

#### 从元组中提取变量

```scala
scala> val (number,string)=(1,"a")
number: Int = 1
string: String = a

scala> println(s"number=$number")
number=1

scala> println(s"string=$string")
string=a  
```

#### 从构造器中提取额变量

```scala
scala> case class Person(name:String,age:Int)
defined class Person

scala> val Person(name,age)=Person("John",30)
name: String = John
age: Int = 30 

scala> println(s"name=$name")
name=John

scala> println(s"age=$age")
age=30
```
### for循环中的模式匹配

如果我们认为for循环中声明的局部迭代变量就是一个普通变量，那么在for循环中使用的模式匹配实质上就是前面提到的变量定义中使用的模式匹配，来看一个列子：

```scala
scala> val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")
capitals: scala.collection.immutable.Map[String,String] = Map(France -> Paris, Japan -> Tokyo)

scala> for ((country, city) <- capitals)
     | println("The capital of "+ country +" is "+ city)
The capital of France is Paris
The capital of Japan is Tokyo
```


参考资料
---

1. [Scala模式匹配](https://fangjian0423.github.io/2015/06/04/scala-pattern-match/)
2. [话说模式匹配(1): 什么是模式？](https://hongjiang.info/scala-pattern-matching-1/)