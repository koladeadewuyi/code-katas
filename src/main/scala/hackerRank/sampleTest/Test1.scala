package hackerRank.sampleTest

import utils.IsTrue

import scala.annotation.tailrec

object Test1 {

  def findNumber(arr: Array[Int], k: Int): IsTrue.Value = {
    find(arr, k)
  }

  @tailrec
  private def find(array: Array[Int], item: Int, isPresent: IsTrue.Value = IsTrue.No): IsTrue.Value = {
    if (array.isEmpty) isPresent
    else {
      if (array.head == item) IsTrue.Yes
      else find(array.tail, item, isPresent)
    }
  }

}
