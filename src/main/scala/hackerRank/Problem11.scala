package hackerRank

import scala.annotation.tailrec

object Problem11 {

  def stepPerms(n: Int): Int = {
    (1 to n).map(i => fibonacci(1, 0, 1, i)).sum
  }

  @tailrec
  private def fibonacci(current: Int, prev: Int, index: Int, n: Int): Int = {
    if (index >= n) current
    else fibonacci(current + prev, current, index + 1, n)
  }

}
