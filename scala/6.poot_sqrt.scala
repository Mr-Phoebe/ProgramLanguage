/*
* @Author: Haonan Wu
* @Date:   2018-01-19 17:00:02
* @Last Modified by:   Haonan Wu
* @Last Modified time: 2018-01-19 17:09:25
*/
object Demo {
    def abs(x: Double): Double = if(x < 0) -x else x

    def sqrtI(guess: Double, x: Double): Double =
        if (isGood(guess, x)) guess
        else sqrtI(improve(guess, x), x)

    def isGood(guess: Double, x: Double): Boolean =
        abs(guess * guess - x) < 0.001

    def improve(guess: Double, x: Double): Double =
        (guess + x/guess) / 2.0

    def sqrt(x: Double): Double = sqrtI(1.0, x)

    def main(args: Array[String]) {
        println(sqrt(2)); println(sqrt(4))
        println(sqrt(1e-6))
        println(sqrt(1e60))
    }
}
