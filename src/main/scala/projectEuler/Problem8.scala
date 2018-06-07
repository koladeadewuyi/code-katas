package projectEuler

import scala.annotation.tailrec

object Problem8 {

  def largestProductInSeries(sequence: String, numberOfAdjacentDigits: Int): Long = {
    compute(sequence, numberOfAdjacentDigits, 0l)
  }

  @tailrec
  private def compute(sequence: String, numberOfAdjacentDigits: Int, largestProduct: Long): Long = {
    if (sequence.isEmpty || sequence.length < numberOfAdjacentDigits) largestProduct
    else {
      val window = sequence.take(numberOfAdjacentDigits)
      val product = window.map(x => Integer.parseInt(x.toString, 10).toLong).product
      if (product > largestProduct) compute(sequence.tail, numberOfAdjacentDigits, product)
      else compute(sequence.tail, numberOfAdjacentDigits, largestProduct)
    }
  }
}
