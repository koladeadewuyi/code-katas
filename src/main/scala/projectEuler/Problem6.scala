package projectEuler

import scala.annotation.tailrec

object Problem6 {

  def sumSquaresDifference(nFirstNumbers: Int): Double = {
    compute(nFirstNumbers)
  }

  @tailrec
  private def compute(number: Int, sumOfSquares: Double = 0, sum: Int = 0): Double = {
    if (number == 0) Math.pow(sum, 2) - sumOfSquares
    else {
      compute(number - 1, sumOfSquares + Math.pow(number, 2), sum + number)
    }
  }
}
