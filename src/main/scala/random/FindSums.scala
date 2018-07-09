package random

import scala.annotation.tailrec

object FindSums {

  @tailrec
  def findSums(nums: Seq[Int], total: Int, complements: Set[Int] = Set.empty): Option[(Int, Int)] = {
    nums.headOption match {
      case Some(num) if complements(num) => Some(total - num, num)
      case Some(num) => findSums(nums.tail, total, complements + (total - num))
      case _ => None
    }
  }

}
