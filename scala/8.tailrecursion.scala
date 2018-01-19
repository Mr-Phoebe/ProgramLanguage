object Demo {
    def factorial(n: Int): Int = {
        if( n <= 1 ) 1
        else n * factorial(n-1)
    }

    def factorialTailrec(n: BigInt, acc: BigInt): BigInt = {
        if(n <= 1) acc
        else factorialTailrec(n-1, acc * n)
    }

    def fibonacci(n: Int): Int = {
        if (n <= 2) 1
        else fibonacci(n - 1) + fibonacci(n - 2)
    }

    def fibonacciTailrec(n: Int, acc1: Int, acc2: Int): Int = {
        if (n < 2) acc2
        else fibonacciTailrec(n - 1, acc2, acc1 + acc2)
    }

    def main(args: Array[String]) {
        println(factorial(5))
        println(factorialTailrec(5, 1))
    }
}
