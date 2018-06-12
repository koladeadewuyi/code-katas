package random

import scala.annotation.tailrec

object CountOccurrenceOfItemInArray {


  /** Counts the number of times an item occurs in an array. Time complexity: O(n), space complexity: N
    *
    * @param array array of elements containing item to be counted
    * @param item item to be counted
    * @param count count of occurrence of item in array
    * @return the count of occurrence of item in array
    */
  @tailrec
  def countOccurrenceOfItem(array: Array[Int], item: Int, count: Int = 0): Int = {
    if (array.isEmpty || array.head != item) count
    else {
      countOccurrenceOfItem(array.tail, item, count + 1)
    }
  }
}
