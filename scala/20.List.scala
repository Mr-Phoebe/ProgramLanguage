object Demo {

    def concatenation(): Unit = {
        /*
            list concatenation
         */
        val site1 = "Runoob" :: ("Google" :: ("Baidu" :: Nil))
        val site2 = "Facebook" :: ("Taobao" :: Nil)

        // 使用 ::: 运算符
        var fruit = site1 ::: site2
        println("site1 ::: site2 : " + fruit)

        // 使用 Set.:::() 方法
        fruit = site1.:::(site2)
        println("site1.:::(site2) : " + fruit)

        // 使用 concat 方法
        fruit = List.concat(site1, site2)
        println("List.concat(site1, site2) : " + fruit)
    }

    def fill(): Unit = {
        val site = List.fill(3)("Runoob") // 重复 Runoob 3次
        println("site : " + site)

        val num = List.fill(10)(2) // 重复元素 2, 10 次
        println("num : " + num)
    }

    def tabulate(): Unit = {
        // 通过给定的函数创建 5 个元素
        val squares = List.tabulate(6)(n => n * n)
        println("一维 : " + squares)

        // 创建二维列表
        val mul = List.tabulate(4, 5)(_ * _)
        println("多维 : " + mul)
    }

    def main(args: Array[String]) {
        concatenation()
        fill()
        tabulate()
    }
}