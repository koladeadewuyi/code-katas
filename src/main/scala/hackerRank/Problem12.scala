package hackerRank

import scala.annotation.tailrec

object Problem12 {

  def fibonacci(x: Int): Int = {
    fibonacci(1, 0, x - 1)
  }

  @tailrec
  private def fibonacci(current: Int, prev: Int, index: Int): Int = {
    if (index <= 0) current
    else fibonacci(current + prev, current, index - 1)
  }

}
