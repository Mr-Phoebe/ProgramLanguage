object Demo {
    def sum(f: Int => Int, a: Int, b: Int): Int = 
      if(a > b) 0 else f(a) + sum(f, a+1, b)

    def id(x: Int): Int = x
    def square(x: Int): Int = x * x
    def powerOfTwo(x: Int): Int = if(x == 0) 1 else 2 * powerOfTwo(x-1)

    def sumInts(a: Int, b: Int): Int = sum(id, a, b)
    def sumSquared(a: Int, b: Int): Int = sum(square, a, b)

    def sumtailrecur(f: Int => Int, a: Int, b: Int) = {
        def loop(a: Int, acc: Int): Int = 
            if(a > b) acc
            else loop(a + 1, f(a) + acc)
        loop(a, 0)
    }

    def sumPowersOfTwo(a: Int, b: Int): Int = sumtailrecur(powerOfTwo, a, b)

    def main(args: Array[String]) {
        println(sumInts(1, 5))
        println(sumSquared(1, 5))
        println(sumPowersOfTwo(1, 5))
    }
}
