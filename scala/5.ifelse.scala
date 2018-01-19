/*
* @Author: Haonan Wu
* @Date:   2018-01-19 16:16:49
* @Last Modified by:   Haonan Wu
* @Last Modified time: 2018-01-19 16:24:27
*/

object Demo {
    def main(args: Array[String]) {
        // statement
        val marks = 55
        var result1 = ""
        if(marks >= 50)
            result1 = "passed"
        else
            result1 = "failed"
        println("Your results just came in, you " + result1 + ".")

        // expression，三元表达式，有返回值
        val result2: String = if(marks >= 50) "passed" else "failed"
        println("Your results just came in, you " + result2 + ".")
        println("Your academic record now shows that you have " + result2 + " the course.")
    }
} 


