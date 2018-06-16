package hackerRank

import utils.IsTrue

import scala.annotation.tailrec

object Problem4 {

  def hasCycle(list: List[Int]): IsTrue.Value = {
    checkFoCycle(list.toVector)
  }

  @tailrec
  private def checkFoCycle(list: Vector[Int], seenItems: Set[Int] = Set.empty, containsCycle: IsTrue.Value = IsTrue.No): IsTrue.Value = {
    if (containsCycle == IsTrue.Yes || list.isEmpty) containsCycle
    else {
      if (seenItems(list.head)) IsTrue.Yes
      else checkFoCycle(list.tail, seenItems + list.head)
    }
  }

}
