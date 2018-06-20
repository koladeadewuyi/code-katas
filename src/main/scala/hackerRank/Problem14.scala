package hackerRank

import scala.annotation.tailrec

object Problem14 {

  def whatFlavors(cost: Vector[Int], money: Int): Vector[Int] = {
    getFlavors(cost, money, 1)
  }

  @tailrec
  private def getFlavors(cost: Vector[Int], money: Int, index: Int, seen: Map[Int, Int] = Map.empty, bought: Vector[Int] = Vector.empty): Vector[Int] = {
    if (cost.isEmpty) bought
    else {
      val head = cost.head
      val balance = money - head
      if (seen.contains(balance)) {
        val balanceIndex = seen(balance)
        getFlavors(cost.tail, money, index + 1, seen + (head -> index),  Vector(balanceIndex, index))
      } else getFlavors(cost.tail, money, index + 1, seen + (head -> index), bought)
    }
  }

}
