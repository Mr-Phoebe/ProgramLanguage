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