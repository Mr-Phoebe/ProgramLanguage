Scala中的require和assert
===

`require`和`assert`都用于在运行时执行某些检查来验证某些条件。

那么他们的差别是什么呢？

- `assert`意味着你的程序已经达到了不一致的状态，这可能是目前的方法/函数的一个问题（我喜欢把它想成HTTP 500 InternalServerError）
- `require`意味着方法的调用者有问题，应该修复它的调用（我喜欢把它看作HTTP 400 BadRequest）

`assert`用`@elidable(ASSERTION)`注解，这意味着你可以使用`-Xelide-ASSERTION`或`-Xdisable-assertions`来编译你的程序，编译器不会为这个断言生成字节码。如果你有大量的断言，这可以显着减少字节码的大小，并提高性能。

知道这一点，你可以使用`assert`来验证程序中的所有不变式（每个方法/函数调用的所有前提条件/后置条件），而不是在“正式”版本中付出代价。

通常情况下，“测试”版本都会启用所有的`assert`，这样会比较慢，因为它会随时验证所有的`assert`，然后可以在没有`assert`的情况下对“正式”版本进行编译。

`require`是不可取消的，它会在库（包括内部库）中使用，以通知调用者调用给定方法/函数的先决条件，例如，被用于限制某些参数。这样对于开发人员严非常有意义。

```scala
def fac(i: Int) = {
    require(i >= 0, "i must be non negative") //this is for correct input

    @tailrec def loop(k: Int, result: Long = 1): Long = {
        assert(result == 1 || result >= k)   //this is only for verification

        if(k > 0) loop(k - 1, result * k) else result
    }

    loop(i)
}
```


