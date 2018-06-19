package random

import scala.annotation.tailrec
import scala.collection.immutable.SortedSet

object IdentifyMissingInteger {

  /** Get the missing integer in a given set of integers. Time complexity: O(n), Space compexity: N
    *
    * @param setOfIntegers set of numbers from 1 to N
    * @param lastNumber last number processed in set iteration
    * @return the missing number in the set
    */
  @tailrec
  def getMissingInteger(setOfIntegers: SortedSet[Int], lastNumber: Int = 0): Option[Int] = {
    if (setOfIntegers.isEmpty) None
    else {
      val head = setOfIntegers.head
      if (head - lastNumber == 1) getMissingInteger(setOfIntegers.tail, head)
      else Some(lastNumber + 1)
    }
  }
}
