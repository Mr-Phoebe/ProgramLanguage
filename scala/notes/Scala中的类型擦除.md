Scala中的类型擦除带来的问题
===

本文旨在展示一些技术来解决由Scala中的类型擦除引起的一些常见问题。

介绍
---

Scala有一个非常强大的类型系统，[Scala是强类型语言](https://www.zhihu.com/question/19918532)。存在类型，结构类型，嵌套类型，路径依赖类型，抽象和具体类型成员，类型边界（(upper, lower, view, context），使用站点和声明站点类型方差，支持类型多态（subtype, parametric, F-bounded, ad-hoc），更高级的类型，广义类型的约束......而且这个名单还在继续。

但是，即使Scala的类型系统在理论上非常强大，实际上一些与类型相关的特性由于其运行时环境的限制而受到了削弱 - 这就是[类型擦除](https://docs.oracle.com/javase/tutorial/java/generics/erasure.html)。

什么是类型擦除？简而言之，这是由Java和Scala编译器执行的一个过程，它在编译后删除所有的泛型类型信息。这意味着我们无法在运行时区分`List [Int]`和`List [String]`。为什么编译器会这样做？那么，因为Java虚拟机（运行Java和Scala的底层运行时环境）并不知道泛型。

类型擦除存在的历史原因。 Java从一开始就不支持泛型。所以当他们最终加入到Java 5中时，他们不得不保持向后兼容性。他们希望允许与旧的非通用遗留代码的无缝接口（这就是为什么我们有Java中的原始类型）。发生了什么是通用类中的类型参数被替换为Object或其上限。例如：

```scala
class Foo[T] {
  val foo: T
}
class Bar[T <: Something] {
  val bar: T
}

//-----type erasure

class Foo {
  val foo: Object
}
class Bar {
  val bar: Something
}
```

所以，运行时我们是不知道泛型类参数化的实际类。在我们的例子中，编译器只能看到原始的Foo和Bar。

不要认为类型擦除是某人无能或无知的产物。这不是坏的设计，而是一种权衡。

我想谈的是我们如何处理Scala中的类型擦除。不幸的是，没有办法防止类型擦除本身，但是我们会看到一些方法来解决它。

它是如何工作的（或不工作）
---

这里有一个简单的擦除类型的例子：

```scala
object Extractor {
  def extract[T](list: List[Any]) = list.flatMap {
    case element: T => Some(element)
    case _ => None
  }
}

val list = List(1, "string1", List(), "string2")
val result = Extractor.extract[String](list)
println(result) // List(1, string1, List(), string2)
```

方法extract()获取各种对象的列表,，因为它拥有Any类型的对象，我们可以把数字、布尔值、字符串、其他对象放入其中。顺便说一句，在一段代码中看到`List [Any]`应该是一个即时的“代码味道”。

所以，我们的愿望是有一个方法，只需要一个混合对象的列表，并只提取某种类型的对象。我们可以通过参数化方法extract()来选择这个类型。在给定的例子中，所选择的类型是String，这意味着我们将尝试从给定列表中提取所有字符串。

从严格的语言角度（没有进入运行时细节），这个代码是合理的。我们知道，模式匹配能够通过解构给定对象的类型而没有问题。但是，由于在JVM上执行的程序，所有通用类型在编译之后被擦除。因此模式匹配不能真正走得太远;类型的“第一级”之外的所有东西都被删除了。直接在Int或String（或任何非泛型类型，如MyNonGenericClass）上匹配我们的变量可以正常工作，但是在T上匹配它（T是泛型参数）则就不能通过编译。编译器会给我们一个警告，说“abstract type pattern T is unchecked since it is eliminated by erasure”。

为了对这些情况提供一些帮助，Scala在2.7版本左右的地方引入了Manifests。 然而，他们有问题，不能代表某些类型，所以Scala 2.10中，他们放弃了它，并使用更强大的TypeTag。

类型标签分为三种不同的类型：

- TypeTag
- ClassTag
- WeakTypeTag

即使这是文档中的官方分类，我认为更好的分类将是这样的：

- TypeTag：
    - “classic”
    - WeakTypeTag
- ClassTag

我的意思是，TypeTag和WeakTypeTag实际上是两个相同的事物，只有一个显着的差异（如我们稍后会显示），而ClassTag是一个完全不同的构造。

ClassTag
---


让我们回到我们的提取器例子，看看我们如何解决类型擦除问题。 我们现在要做的就是向extract()方法添加一个隐式参数：

```scala
import scala.reflect.ClassTag
object Extractor {
  def extract[T](list: List[Any])(implicit tag: ClassTag[T]) =
    list.flatMap {
      case element: T => Some(element)
      case _ => None
    }
}
val list: List[Any] = List(1, "string1", List(), "string2")
val result = Extractor.extract[String](list)
println(result) // List(string1, string2)
```

打印语句显示`List（string1，string2）`。 

请注意，我们也可以在这里使用上下文绑定语法：

```scala
// def extract[T](list: List[Any])(implicit tag: ClassTag[T]) =
def extract[T : ClassTag](list: List[Any]) =
```

我将使用标准语法来简化代码，不需要额外的语法糖。

那么它是怎样工作的？那么，当我们需要一个类型为ClassTag的隐式值时，编译器会为我们创建这个值。文档说：

>If an implicit value of type u.ClassTag[T] is required, the compiler will make one up on demand.  
>如果需要一个类型为`u.ClassTag [T]`的隐式值，编译器会根据需要创建一个。

所以，编译器很乐意为我们提供一个需要ClassTag的隐式实例。这种机制也将与`TypeTag`和`WeakTypeTag`一起使用。

我们在`extract()`方法中提供了隐式的`ClassTag`值。一旦我们进入方法体内部会发生什么？

再次看一下这个例子 - 编译器不仅自动为我们提供了隐式参数标记的值，而且我们也不需要使用参数本身。我们从来不需要对`Tag`值做任何事情。只是因为它存在，我们的模式匹配就能够成功匹配我们列表中的字符串元素。

我们可以检查文档以寻找解释。事实上，它隐藏在这里：

>Compiler tries to turn unchecked type tests in pattern matches into checked ones by wrapping a (_: T) type pattern as ct(_: T), where ct is the ClassTag[T] instance.  
>编译器试图通过包装一个`(_：T)`类型模式为`ct(_：T)`，其中ct是`ClassTag [T]`实例，将模式匹配中未经检查的类型测试变成已检查的类型。


基本上，如果我们为编译器提供一个隐式的ClassTag，它会重写模式匹配中的条件，以使用给定的标签作为extractor。我们的条件：

```scala
{case element: T => Some(element)}
```

由编译器翻译（如果在范围内有一个隐含的标签）到这里：

```scala
{case (element @ tag(_: T)) => Some(element)}
```

如果你以前从未见过“@”构造，那只是给你匹配的类命名的一种方法，例如：

```scala
{
    case Foo(p, q) => 
        // we can only reference parameters via p and q
    case f @ Foo(p, q) => 
        // we can reference the whole object via f
}
```

如果没有可用的类型为T的隐式`ClassTag`，则编译器将被削弱（由于缺少类型信息），并且会发出警告，表明我们的模式匹配将受到类型T上的类型擦除的损害。编译不会中断，但是当我们进行模式匹配时，不要期望编译器知道什么是T（因为它将在运行时被JVM擦除）。如果我们为类型T提供了一个隐式的`ClassTag`，那么编译器会很高兴在编译时提供一个合适的`ClassTag`，就像我们在例子中看到的那样。标签将带来关于T是一个字符串的信息，类型删除不能触摸它。

但是有一个重要的弱点。如果我们想要在更高级别上区分我们的类型，并从我们的初始列表中获得`List [Int]`的值，而忽略例如列出`[String]`，我们不能这样做：

```scala
val list: List[List[Any]] = List(List(1, 2), List("a", "b"))
val result = Extractor.extract[List[Int]](list)
println(result) // List(List(1, 2), List(a, b))
```

我们只想提取`List [Int]`，但是我们也得到了`List [String]`。`Class tags`不能在更高层次上进行区分。

这意味着我们的提取器可以区分例如`sets`和`lists`，但它不能将一个列表与另一个列表区分开来（例如`List [Int]`和`List [String]`）。当然，这不仅仅是对于列表，这适用于所有的通用trait/class。

TypeTag
---

`ClassTag`失败的地方，开发人员用`TypeTag`来弥补。 它可以区分`List [String]`和`List [Integer]`。 它也可以更深入一些，比如区分`List [Set [String]]`中的`List [Set [Int]]`。因为TypeTag在运行时有更丰富的关于泛型类型的信息。 

我们可以很容易地得到所讨论类型的完整路径以及所有嵌套类型（如果有的话）。 要得到这个信息，你只需要在给定的标签上调用tpe()。

这是一个例子。 隐式标签参数由编译器提供，就像ClassTag一样。 请注意“args”参数 - 它是包含ClassTag没有的其他类型信息的信息（有关由Int参数化的List的信息）。

```scala
import scala.reflect.runtime.universe._
object Recognizer {
  def recognize[T](x: T)(implicit tag: TypeTag[T]): String =
    tag.tpe match {
      case TypeRef(utype, usymbol, args) =>
        List(utype, usymbol, args).mkString("\n")
    }
}

val list: List[Int] = List(1, 2)
val result = Recognizer.recognize(list)
println(result)
// prints:
//   scala.type
//   type List
//   List(Int)
```

我在这里介绍了一个新的对象 - 一个Recognizer。

不幸的是，我们无法使用TypeTags实现Extractor。但是我们可以获得更多关于类型的信息，比如了解更高类型（也就是说，能够区分`List[X]`和`List[Y]`），但是它们的缺点是它们不能用于运行。

我们可以使用TypeTag在运行时获取某种类型的信息，但是我们不能用它来在运行时找出某个对象的类型。我们传入recognize()的是一个简单的`List [Int]`;这是我们的`List(1,2)`值的声明类型。但是，如果我们将`List(1,2)`声明为`List [Any]`，TypeTag会告诉我们我们已经通过一个`List [Any]`。

下面是ClassTags和TypeTag之间的两个主要区别：

1. ClassTag不知道“更高类型”;给定一个`List [T]`，一个ClassTag只知道这个值是一个`List`，对`T`一无所知。
2. TypeTag知道“更高类型”，并且有更丰富的类型信息，但不能用于在运行时获取有关值的类型信息。换句话说，TypeTag提供了关于类型的运行时信息，而ClassTag提供了关于该值的运行时信息（更具体地说，是在运行时告诉我们所讨论的值的实际类型的信息）。

还有一点值得一提的是ClassTag和(Weak)TypeTag之间的区别：ClassTag是一个经典的老式类。它为每个类型捆绑了一个单独的实现，这使得它成为一个标准的类型模式。另一方面，(Weak)TypeTag有点复杂，为了使用它，我们需要在代码中有一个特殊的导入，正如你在前面给出的代码片段中注意到的那样。我们需要导入universe：

>Universe provides a complete set of reflection operations which make it possible for one to reflectively inspect Scala type relations, such as membership or subtyping.  
>Universe提供了一套完整的反射操作，使得人们可以反思性地检查Scala类型关系，例如成员资格或子类型。

不要担心，只需要导入正确的Universe，并且在(Weak)TypeTag（scala.reflect.runtime.universe._ (docs)）的情况下。

WeakTypeTag
---

您可能觉得TypeTag和WeakTypeTag是非常相似的，因为迄今为止所有的差异都是在ClassTag中解释的。 这是正确的; 他们确实是同一个工具的两个变种。 但是，有一个重要的区别。

我们看到TypeTag足够聪明，可以检查类型，类型参数，类型参数等等。但是，所有类型都是具体的。 如果一个类型是抽象的，TypeTag将无法解决它。 这是WeakTypeTag进场的地方。 让我们来修改TypeTag示例一下：

```scala
val list: List[Int] = List(1, 2)
val result = Recognizer.recognize(list)
```

看那边的那个Int？它可以是任何其他具体类型，如`String`，`Set [Double]`或`MyCustomClass`。但是如果你有一个抽象类型，你需要一个`WeakTypeTag`。

这是一个例子。 请注意，我们需要对抽象类型的引用，所以我们只需将所有内容都包含在抽象类中。

```scala
import scala.reflect.runtime.universe._
abstract class SomeClass[T] {
  object Recognizer {
    def recognize[T](x: T)(implicit tag: WeakTypeTag[T]): String =
      tag.tpe match {
        case TypeRef(utype, usymbol, args) =>
          List(utype, usymbol, args).mkString("\n")
      }
  }

  val list: List[T]
  val result = Recognizer.recognize(list)
  println(result)
}

new SomeClass[Int] { val list = List(1) }
// prints:
//   scala.type
//   type List
//   List(T)
```

结果类型是一个`List [T]`。 

如果我们使用TypeTag而不是WeakTypeTag，编译器会抱怨“no TypeTag available for List[T]”。 所以，你可以把WeakTypeTag看作TypeTag的一个超集。

请注意，WeakTypeTag尽可能具体，所以如果有一个类型标签可用于某种抽象类型，WeakTypeTag将使用该类型标记，从而使类型具体而不是抽象的。

结论
---

在我们完成之前，让我提一下，每个类型标签也可以使用可用的助手来显式实例化：

```scala
import scala.reflect.classTag
import scala.reflect.runtime.universe._

val ct = classTag[String]
val tt = typeTag[List[Int]]
val wtt = weakTypeTag[List[Int]]

val array = ct.newArray(3)
array.update(2, "Third")

println(array.mkString(","))
println(tt.tpe)
println(wtt.equals(tt))

//  prints:
//    null,null,Third
//    List[Int]
//    true
```

就这样。 我们看到了三个构造，ClassTag，TypeTag和WeakTypeTag，它们将帮助您在日常Scala生活中解决大部分类型的擦除问题。 

请注意，使用标签（这基本上是反射下）可以减慢速度，使生成的代码显着变大，所以不要在你的库中添加隐式类型标签，以使编译器更加“智能” 没有实际的原因。 保存它们，当你真的需要它们。 

而当你需要它们的时候，它们将会提供一个强大的武器来对付JVM的类型擦除。












