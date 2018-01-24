object Demo {
    def main(args: Array[String]) {
        val x = 0
        val y = 1
        //在scala中{}中可包含一系列表达式，块中最后一个【表达式】的值就是块的值
        //下面就是两个块表达式
        val result = {
            //块1
            if (x <= 0) {
                -1
            } else if (x >= 1) {
                1
            } else {
                "error"
            }
            //块2
            if (y > 0) {
                "true"
            } else {
                "false"
            }
        }
        //result的值就是块表达式的结果
        println(result)
    }
}
