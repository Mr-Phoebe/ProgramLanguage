import Array._
 
object Student {
   def main(args: Array[String]) {
      var id = range(7, 23, 3)
      var age = range(15,20)
      for ( s <- id ) {
         print( " " + s)
      }
      println()
      for ( a <- age ) {
         print( " " + a )
      }
   }
}
