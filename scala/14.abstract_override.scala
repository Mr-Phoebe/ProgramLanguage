/*
Extends of trait class and abstrct class don't need override
*/
object Testclass {
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




