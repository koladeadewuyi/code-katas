package random

import scala.annotation.tailrec
import scala.collection.immutable.SortedSet

object IdentifyingDuplicates {

  /**
    *
    * @param listOfNumbers
    * @param seenItems
    * @param duplicates
    * @return
    */
  @tailrec
  def findDuplicates(listOfNumbers: List[Int], seenItems: SortedSet[Int] = SortedSet.empty[Int], duplicates: SortedSet[Int] = SortedSet.empty[Int]): SortedSet[Int] = {
    if (listOfNumbers.isEmpty) duplicates
    else {
      val head = listOfNumbers.head
      if (seenItems.contains(head)) findDuplicates(listOfNumbers.tail, seenItems, duplicates + head)
      else findDuplicates(listOfNumbers.tail, seenItems + head, duplicates)
    }
  }
}
