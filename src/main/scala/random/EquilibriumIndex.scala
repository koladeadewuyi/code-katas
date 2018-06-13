package random

import scala.annotation.tailrec

object EquilibriumIndex {

  /**
    *
    * @param listOfNumbers
    * @return
    */
  def getEquilibriumIndices(listOfNumbers: List[Int]): List[Int] = {
    val total = listOfNumbers.sum
    val currentItem = listOfNumbers.head
    compute(listOfNumbers.tail ++ List(0), 0, currentItem, 0, total - currentItem, List.empty[Int])
  }

  /**
    *
    * @param listOfNumbers
    * @param index
    * @param leftSum
    * @param rightSum
    * @param equilibriumIndices
    * @return
    */
  @tailrec
  private def compute(listOfNumbers: List[Int], index: Int, currentItem: Int, leftSum: Int, rightSum: Int, equilibriumIndices: List[Int] = List.empty[Int]): List[Int] = {
    if (listOfNumbers.isEmpty) equilibriumIndices
    else {
      val newLeftSum = leftSum + currentItem
      val newRightSum = rightSum - listOfNumbers.head
      if (rightSum == leftSum) compute(listOfNumbers.tail, index + 1, listOfNumbers.head, newLeftSum, newRightSum, equilibriumIndices ++ List(index))
      else compute(listOfNumbers.tail, index + 1, listOfNumbers.head, newLeftSum, newRightSum, equilibriumIndices)
    }
  }
}
