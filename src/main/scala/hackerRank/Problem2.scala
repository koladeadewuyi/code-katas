package hackerRank

object Problem2 {

  val MaxStringLength: Double = math.pow(10, 4)

  def numOfCharsToDelete(a: String, b: String): Int = {
    require(a.nonEmpty && b.nonEmpty)
    require(a.length <= MaxStringLength && b.length <= MaxStringLength)
    val commonChars = a.intersect(b)
    a.diff(commonChars).length + b.diff(commonChars).length
  }

}
