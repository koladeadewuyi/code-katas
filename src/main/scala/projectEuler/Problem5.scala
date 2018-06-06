package projectEuler

import scala.annotation.tailrec

object Problem5 {

  def computeSmallestMultiple(smallestDivisor: Int, largestDivisor: Int): Int = {
    val divisors = smallestDivisor to largestDivisor
    compute(divisors, largestDivisor)
  }

  @tailrec
  private def compute(divisors: Seq[Int], number: Int): Int = {
    if (divisors.forall(divisor => number % divisor == 0)) number
    else {
      compute(divisors, number + 1)
    }
  }
}
