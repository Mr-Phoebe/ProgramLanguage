# scala中的隐式转换与隐式参数

## 简介

在scala语言中，隐式转换是无处不在的，它们存在固有的隐式转换，不需要人工进行干预。

![这里写图片描述](http://img.blog.csdn.net/20180204071421495?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvdTAxMzAwNzkwMA==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

这是我们之前说的Scala类的继承情况，虚线标注出了Scala帮我们实现的隐式转化。

例如Float在必要情况下自动转换为Double类型

在 [scala中的泛型编程](http://blog.csdn.net/u013007900/article/details/79212647)的视图界定中我们也提到，视图界定可以跨越类层次结构进行，它背后的实现原理就是隐式转换。例如Int类型会视图界定中会自动转换成RichInt，而RichInt实现了Comparable接口，当然这里面的隐式转换也是scala语言为我们设计好的。

## 隐式转换函数

下列赋值如果没有隐式转换的话会报错，添加隐式转换函数后可以实现String类型到Int类型的赋值：


```
object ImplicitDefDemo {

    object MyImplicitTypeConversion {
        implicit def strToInt(str: String) = str.toInt
    }

    def main(args: Array[String]) {
        //compile error!
        //val max = math.max("1", 2);
        import MyImplicitTypeConversion.strToInt
        val max = math.max("1", 2);
        println(max)
    }
}
```
隐式函数的名称对结构没有影响，即`implicit def strToInt(str: String) = str.toInt`函数可以是任何名字。只是采用source2Target或者sourceToTarget这种方式函数的意思比较明确，阅读代码的人可以见名知义，增加代码的可读性。

隐式转换功能十分强大，可以快速地扩展现有类库的功能，例如下面的代码：

```scala
import java.io.File
import scala.io.Source

//RichFile类中定义了Read方法
class RichFile(val file:File) {
  def read = Source.fromFile(file).getLines().mkString
}

object ImplicitFunction extends App {
  implicit def double2Int(x: Double) = x.toInt
  var x: Int = 3.5

  //隐式函数将java.io.File隐式转换为RichFile类
  implicit def file2RichFile(file: File) = new RichFile(file)
  val f = new File("file.log").read
  println(f)
}
```
前面我们也提到，scala会默认帮我们引用Predef对象中所有的方法，Predef中定义了很多隐式转换函数，下面是Predef的部分隐式转换源码：

```scala
scala> :implicits -v
/* 78 implicit members imported from scala.Predef */
  /* 48 inherited from scala.Predef */
  implicit def any2ArrowAssoc[A](x: A): ArrowAssoc[A]
  implicit def any2Ensuring[A](x: A): Ensuring[A]
  implicit def any2stringadd(x: Any): runtime.StringAdd
  implicit def any2stringfmt(x: Any): runtime.StringFormat
  implicit def boolean2BooleanConflict(x: Boolean): Object
  implicit def byte2ByteConflict(x: Byte): Object
  implicit def char2CharacterConflict(x: Char): Object
  implicit def double2DoubleConflict(x: Double): Object
  implicit def float2FloatConflict(x: Float): Object
  implicit def int2IntegerConflict(x: Int): Object
  implicit def long2LongConflict(x: Long): Object
  implicit def short2ShortConflict(x: Short): Object

 //....................
```

## [隐式转化类](http://docs.scala-lang.org/overviews/core/implicit-classes.html)

隐式类有如下几个限制：

1. 他们必须在别的trait/class/object中定义
2. 他们的主构造器必须接受一个非隐式的变量
3. 在相同范围内，任何方法，成员或对象不得具有与隐式类相同的名称。
	- 注意：这意味着一个隐式类不能是一个case类。

隐式类与旧的隐式转换的语法（implicit def）是有细微的不同的，隐式类的运作方式是：隐式类的主构造函数只能有一个参数（有两个以上并不会报错，但是这个隐式类永远不会被编译器作为隐式类在隐式转化中使用），且这个参数的类型就是将要被转换的目标类型。

从语义上这很自然：这个隐式转换类将包裹目标类型，隐式类的**所有方法**都会自动“附加”到目标类型上。

但是关于这个我其实有点疑问，因为它不能改自动执行，反而像是我们在外面帮它套了一层方法一样。

```scala
object ImplicitClassDemo {

    implicit class MyImplicitTypeConversion(val str: String) {
        def str2Int: Int = str.toInt
        def str2Double: Double = str.toDouble
    }

    def main(args: Array[String]): Unit = {

        import Demo.MyImplicitTypeConversion
        var a: Int = "1".str2Int
		var b: Double = "2.6".str2Double
    }
}
```


## 隐式转换规则

那什么时候会发生隐式转换呢？主要有以下几种情况： 

1. 当方法中参数的类型与实际类型不一致时，例如

```scala
implicit def double2Int(x:Double) = x.toInt
def f(x:Int) = x 
//方法中输入的参数类型与实际类型不一致，此时会发生隐式转换  
//double类型会转换为Int类型，再进行方法的执行 

f(3.14)
```
2. 当调用类中不存在的方法或成员时，会自动将对象进行隐式转换，例如：

```scala
import java.io.File
import scala.io.Source

//RichFile类中定义了Read方法
class RichFile(val file:File) {
  def read = Source.fromFile(file).getLines().mkString
}

object ImplicitFunction extends App {
  implicit def double2Int(x: Double) = x.toInt
  var x: Int = 3.5

  //隐式函数将java.io.File隐式转换为RichFile类
  implicit def file2RichFile(file: File) = new RichFile(file)
  val f = new File("file.log").read
  println(f)
}
```
前面我们讲了什么情况下会发生隐式转换，下面我们讲一下什么时候不会发生隐式转换：

1. 编译器可以不在隐式转换的编译通过，则不进行隐式转换，例如


```scala
//下面几条语句，不需要自己定义隐式转换编译就可以通过
//因此它不会发生前面定义的隐式转换
scala> 3.0*2
res0: Double = 6.0

scala> 2*3.0
res1: Double = 6.0

scala> 2*3.7
res2: Double = 7.4

```
2. 如果转换存在二义性，则不会发生隐式转换，例如


```scala
package implicitConversion{
  object ImplicitConversion{
    implicit def double2Int(x: Double) = x.toInt
    //这里定义了一个隐式转换
    implicit def file2RichFile(file: File) = new RichFile(file)
    //这里又定义了一个隐式转换，目的与前面那个相同
    implicit def file2RichFile2(file: File) = new RichFile(file)
  }

}

class RichFile(val file:File){
  def read=Source.fromFile(file).getLines().mkString
}

object ImplicitFunction extends App {
  import cn.scala.xtwy.implicitConversion.ImplicitConversion._
  var x:Int = 3.5

  val f = new File("file.log").read
/*  
	上面这条语句在编译时会出错，提示信息如下：
	type mismatch; found : java.io.File required:
	 ?{def read: ?} Note that implicit conversions 
	are not applicable because they are ambiguous: 
	both method file2RichFile in object 
	ImplicitConversion of type (file: 
	java.io.File)cn.scala.xtwy.RichFile and method 
	file2RichFile2 in object ImplicitConversion of 
	type (file: java.io.File)cn.scala.xtwy.RichFile 
	are possible conversion functions from java.io.File to ?{def read: ?}
	value read is not a member of java.io.File
*/
}
```
编译提示隐式转换存在二义性（ambiguous）

3. 隐式转换不会嵌套进行，例如


```scala
import java.io.File
import scala.io.Source

object ImplicitConversion {
    implicit def double2Int(x: Double): Int = x.toInt
    implicit def file2RichFile(file: File): RichFile = new RichFile(file)
    //implicit def file2RichFile2(file:File)=new RichFile(file)
    implicit def richFile2RichFileAnother(file: RichFile) = new RichFileAnother(file)
}


class RichFile(val file:File) {
    def read = Source.fromFile(file).getLines().mkString
}

//RichFileAnother类，里面定义了read2方法
class RichFileAnother(val file:RichFile) {
    def read2=file.read
}

object ImplicitFunction extends App {
    import ImplicitConversion._
    var x:Int = 3.5

    //隐式转换不会多次进行，下面的语句会报错
    //不能期望会发生File到RichFile，然后RifchFile到
    //RichFileAnthoer的转换
    val f=new File("file.log").read2
    println(f)
}

```
注意这里指的是源类型到目标类型的转换只会进行一次，并不是说不存在多次隐式转换，在一般的方法调用过程中可能会出现多次隐式转换，例如：


```scala
class ClassA {
  override def toString() = "This is Class A"
}
class ClassB {
  override def toString() = "This is Class B"
}
class ClassC {
  override def toString() = "This is  ClassC"
  def printC(c: ClassC) = println(c)
}
class ClassD

object ImplicitWhole extends App {
  implicit def B2C(b: ClassB) = {
    println("B2C")
    new ClassC
  }
  implicit def D2C(d: ClassD) = {
    println("D2C")
    new ClassC
  }
  //下面的代码会进行两次隐式转换
  //因为ClassD中并没有printC方法
  //因为它会隐式转换为ClassC（这是第一次,D2C）
  //然后调用printC方法
  //但是printC方法只接受ClassC类型的参数
  //然而传入的参数类型是ClassB
  //类型不匹配，从而又发生了一次隐式转地换(这是第二次,B2C）
  //从而最终实现了方法的调用
  new ClassD().printC(new ClassB)
}
```
还有一种情况也会发生多次隐式转换，如果给函数定义了隐式参数，在实际执行过程中可能会发生多次隐式转换，代码如下：


```
object Main extends App {
  class PrintOps() {
    def print(implicit i: Int) = println(i);
  }

  implicit def str2PrintOps(s: String) = {
    println("str2PrintOps")
    new PrintOps
  }

  implicit def str2int(implicit s: String): Int = {
    println("str2int")
    Integer.parseInt(s)
  }

  implicit def getString = {
    println("getString")
    "123"
  }
  //下面的代码会发生三次隐式转换
  //首先编译器发现String类型是没有print方法的
  //尝试隐式转换，利用str2PrintOps方法将String
  //转换成PrintOps（第一次）
  //然后调用print方法，但print方法接受整型的隐式参数
  //此时编译器会搜索隐式值，但程序里面没有给定，此时
  //编译器会尝试调用 str2int方法进行隐式转换，但该方法
  //又接受一个implicit String类型参数，编译器又会尝试
  //查找一个对应的隐式值，此时又没有，因此编译器会尝试调用
  //getString方法对应的字符串（这是第二次隐式转换，
  //获取一个字符串，从无到有的过程）
  //得到该字符串后，再调用str2int方法将String类型字符串
  //转换成Int类型（这是第三次隐式转换）
  "a".print
}
```



## 隐式参数

在一般的函数据定义过程中，需要明确传入函数的参数，代码如下：


```scala
class Student(var name:String) {
  //将Student类的信息格式化打印
  def formatStudent(outputFormat: OutputFormat) = {
    outputFormat.first+" "+this.name+" "+outputFormat.second
  }
}

class OutputFormat(var first:String,val second:String)

object ImplicitParameter {
  def main(args: Array[String]): Unit = {
    val outputFormat=new OutputFormat("<<",">>")
    println(new Student("john").formatStudent(outputFormat))
  }
}
//执行结果
//<< john >>
```

如果给函数定义隐式参数的话，则在使用时可以不带参数，代码如下：


```scala
class Student(var name:String){
  //利用柯里化函数的定义方式，将函数的参数利用
  //implicit关键字标识
  //这样的话，在使用的时候可以不给出implicit对应的参数
  def formatStudent()(implicit outputFormat:OutputFormat) = {
    outputFormat.first+" "+this.name+" "+outputFormat.second
  }
}

class OutputFormat(var first:String,val second:String)

object ImplicitParameter {
  def main(args: Array[String]): Unit = {
    //程序中定义的变量outputFormat被称隐式值
    implicit val outputFormat = new OutputFormat("<<",">>")
    
	//在.formatStudent()方法时，编译器会查找类型
    //为OutputFormat的隐式值,本程序中定义的隐式值
    //为outputFormat
    println(new Student("john").formatStudent())
  }
}
```



## 隐式参数中的隐式转换

我们提到函数中如果存在隐式参数，在使用该函数的时候如果不给定对应的参数，则编译器会自动帮我们搜索相应的隐式值，并将该隐式值作为函数的参数，这里面其实没有涉及到隐式转换，本节将演示如何利用隐式参数进行隐式转换，下面的代码给定的是一个普通的比较函数：


```scala
object ImplicitParameter extends App {
//下面的代码不能编译通过
//这里面泛型T没有具体指定，它不能直接使用
//<符号进行比较
  def compare[T](first:T,second:T)={
    if (first < second) 
      first 
    else 
      second
  }
}
```
上面的代码要想使其编译通过，可以之前讲的类型变量界定和视图界定指定其上界为Ordered[T]，例如：

```scala
object ImplicitParameter extends App {
  //指定T的上界为Ordered[T]，所有混入了特质Ordered
  //的类都可以直接的使用<比较符号进行比较

  def compare[T<:Ordered[T]](first:T,second:T)={
    if (first < second) 
      first 
    else 
      second
  }
}
```
这是一种解决方案，我们还有一种解决方案就是通过隐式参数的隐式转换来实现，代码如下：

```scala
object ImplicitParameter extends App {
//下面代码中的(implicit order:T=>Ordered[T])
//给函数compare指定了一个隐式参数
//该隐式参数是一个隐式转换
  def compare[T](first:T,second:T)(implicit order:T=>Ordered[T])={
    if (first > second) 
      first 
    else 
      second
  }
  println(compare("A","B"))
}
```
## 函数中隐式参数使用概要

要点1：在定义函数时，如果函数没有柯里化，implicit关键字会作用于所有参数，例如：

```scala
//implicit关键字在下面的函数中只能出现一次
//它作用于两个参数x,y，也即x,y都是隐式参数
def sum(implicit x: Int, y: Int) = x + y
//下面的函数不合法，函数如果没有柯里化，不能期望
//implicit关键字会作用于其中一个参数
//def sum(x: Int, implicit y: Int) = x + y
//def sum(implicit x: Int, implicit y: Int) = x + y
```
另外，值得注意的是，`def maxFunc(implicit x: Int, y: Int) = x + y` 在使用时，也只能指定一个隐式值，即指定的隐式值分别会对应函数中的参数（这里是`x`,`y`），代码如下：

```scala
def sum(implicit x: Int, y: Int) = x + y
//只能指定一个隐式值

//例如下面下定义的x会自动对应maxFunc中的
//参数x,y即x=3, y=3，从而得到的结果是6

implicit val x:Int = 3

//不能定义两个隐式值
//implicit val y:Int=4
println(sum)
```
要想使用implicit只作用于某个函数参数，则需要将函数进行柯里化，如：

```scala
def sum(x: Int)(implicit y:Int) = x+y
```
值得注意的是，下面这种两种带隐式参数的函数也是不合法的

```scala
def sum(x: Int)(implicit y:Int)(d:Int) = x+y+d
def sum(x: Int)(implicit y:Int)(implicit d:Int) = x+y+d
```
要点2: 匿名函数不能使用隐式参数，例如：


```scala
val sum2 = (implicit x:Int) => x+1
```
要点3: 如何函数带有隐式参数，则不能使用其偏函数，例如：

```
def sum(x: Int)(implicit y:Int) = x + y
//不能定义sum的偏函数，因为它带有隐式参数
//could not find implicit value for 
//parameter y: Int
//not enough arguments for method sum:
// (implicit y: Int)Int. Unspecified value parameter y.
def sum2 = sum _
```







参考资料
--

1. [scala 隐式参数 implicit parameters](http://www.codeweblog.com/scala-%E9%9A%90%E5%BC%8F%E5%8F%82%E6%95%B0-implicit-parameters/)
2. [Scala之隐式转换](http://blog.csdn.net/bluishglc/article/details/50866314)