object Demo {
    def abs(x: Double): Double = if(x < 0) -x else x


    def sqrt(x: Double): Double = {
        def sqrtI(guess: Double): Double =
            if (isGood(guess)) guess
            else sqrtI(improve(guess))

        def isGood(guess: Double): Boolean =
            abs(guess * guess - x) < 0.001

        def improve(guess: Double): Double =
            (guess + x/guess) / 2.0

        sqrtI(1.0)
    }


    def main(args: Array[String]) {
        println(sqrt(2))
        println(sqrt(4))
        println(sqrt(1e-6))
    }
}
