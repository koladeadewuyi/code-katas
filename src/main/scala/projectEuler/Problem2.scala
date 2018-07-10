package projectEuler

import scala.annotation.tailrec

/**
 * Created by koladeadewuyi@gmail.com on 26/12/2016.
 */
object Problem2 {
  val phi: Double = (1 + Math.sqrt(5)) / 2
  val inversePhi: Double = 1 / phi

  def sumOfEvenFibonacciBelow(limit: Long): Long = {
    getSum(limit)
  }

  @tailrec
  private def getSum(limit: Long, sum: Long = 0l, number: Long = 0l, index: Int = 3): Long = {
    val number = ((Math.pow(phi, index) - Math.pow(-inversePhi, index)) / Math.sqrt(5)).toLong

    if (number > limit) sum
    else {
      getSum(limit, sum + number, number, index + 3)
    }
  }
}
