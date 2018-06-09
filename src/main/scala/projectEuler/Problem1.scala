package projectEuler

import scala.annotation.tailrec

/**
 * Created by koladeadewuyi@gmail.com on 26/12/2016.
 */
object Problem1 {

  def sumOfMultiples(number: Int, divisors: List[Int]): Int = {
    if (number < 1 || divisors.isEmpty) 0
    else {
      sumIncludingDupes(number, divisors) - sumOfDupes(number, divisors)
    }
  }

  def sumOfDupes(number: Int, divisors: List[Int]): Int = {
    sumIncludingDupes(number, List(divisors.product))
  }

  @tailrec
  def sumIncludingDupes(number: Int, divisors: List[Int], sum: Int = 0): Int = {
    if (divisors.isEmpty) {
       sum
    } else {
      val divisor = divisors.head
      val largestMultiple = Math.floor((number - 1) / divisor).toInt
      val sumForDivisor = largestMultiple * (divisor + (largestMultiple * divisor)) / 2
      sumIncludingDupes(number, divisors.tail, sum + sumForDivisor)
    }
  }

}