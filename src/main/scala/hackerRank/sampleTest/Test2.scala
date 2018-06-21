package hackerRank.sampleTest

object Test2 {

  def oddNumbers(l: Int, r: Int): Array[Int] = {
    for (number <- (l to r).toArray if number % 2 != 0) yield number
  }

}
