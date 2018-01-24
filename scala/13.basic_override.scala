/*
Basic feature
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