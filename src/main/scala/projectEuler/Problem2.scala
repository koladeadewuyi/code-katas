package projectEuler

/**
 * Created by koladeadewuyi@gmail.com on 26/12/2016.
 */
object Problem2 {
  val phi = (1 + Math.sqrt(5)) / 2
  val _phi = 1 / phi

  def sumOfEvenFibonacciBelow(limit: Long): Long = {
    getSum(limit)
  }

  private def getSum(limit: Long, sum: Long = 0l, number: Long = 0l, index: Int = 3): Long = {
    val number = ((Math.pow(phi, index) - Math.pow(-_phi, index)) / Math.sqrt(5)).toLong

    if (number > limit) sum
    else {
      getSum(limit, sum + number, number, index + 3)
    }
  }
}
