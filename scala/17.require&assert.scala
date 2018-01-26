import scala.annotation.tailrec

object Demo {
    def fac(i: Int) = {
        require(i >= 0, "i must be non negative") //this is for correct input

        @tailrec def loop(k: Int, result: Long = 1): Long = {
            assert(result == 1 || result >= k)   //this is only for verification

            if(k > 0) loop(k - 1, result * k) else result
        }

        loop(i)
    }
    def main(args: Array[String]): Unit = {
        println(fac(5))
    }
}

/*
https://stackoverflow.com/questions/26140757/what-to-choose-between-require-and-assert-in-scala
assert means that your program has reached an inconsistent state,
    this might be a problem with the current method/function 
    (I like to think of it a bit as HTTP 500 InternalServerError)
require means that the caller of the method is at fault 
    and should fix its call 
    (I like to think of it a bit as HTTP 400 BadRequest)
*/
