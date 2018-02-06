object Capitals {
  def useImmut() {
    var capital = Map("US" -> "Washington", "France" -> "Paris")
    capital += ("Japan" -> "Tokyo")
    println(capital("France")) 
  }

  def useMut() {
    import scala.collection.mutable.Map  // only change needed!
    var capital = Map("US" -> "Washington", "France" -> "Paris")
    capital += ("Japan" -> "Tokyo")
    println(capital("France")) 
  }

  def main(args: Array[String]) {
    useImmut()
    useMut()
  }
}
