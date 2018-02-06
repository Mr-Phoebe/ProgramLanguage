object Misc {
  object Obj1 {
    import scala.collection.mutable
    
    val synchroSet =
      new mutable.HashSet[Int] with
          mutable.SynchronizedSet[Int]
  }

  val tuple1 =
    (1, "hello", Console)
  
  def main(args: Array[String]) {
    println("Obj1.synchroSet [" + Obj1.synchroSet + "]")
    println("tuple1 [" + tuple1 + "]")
  }
}
