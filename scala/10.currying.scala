object Demo {
        def sum1(f: Int => Int): (Int, Int) => Int = {
        def sumF(a: Int, b: Int): Int =
            if(a > b) 0
            else f(a) + sumF(a+1, b)
        sumF
    }

    def sum2(f: Int => Int)(a: Int, b: Int): Int =
        if(a > b)  1
        else f(a) + sum2(f)(a+1, b)

    def powerOfTwo(x: Int): Int = if(x == 0) 1 else 2 * powerOfTwo(x-1)

    def sumInts = sum1(x => x)
    def sumSquared = sum1(x => x * x)
    def sumPowersOfTwo(a: Int, b:Int) = sum2(powerOfTwo)(a, b)

    def main(args: Array[String]) {
        println(sumInts(1, 5))
        println(sumSquared(1, 5))
        println(sumPowersOfTwo(1, 5))
    }
}
