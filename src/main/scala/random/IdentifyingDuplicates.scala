package random

import scala.annotation.tailrec
import scala.collection.immutable.SortedSet

object IdentifyingDuplicates {

  /** This method find the duplicate integers in a list of integers
    *
    * @param listOfNumbers the list of integers in which to find duplicates
    * @param seenItems a set of the items in the list which have been seen
    * @param duplicates a set of the duplicate items in the list
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
