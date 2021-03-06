package random

import scala.annotation.tailrec

object Permutation {

  def permutation(n: Int, r: Int): Int = {
    compute(n, n - r)
  }

  @tailrec
  private def compute(num: Int = 1, deNum: Int = 1, newNum: Int = 1, newDeNum: Int = 1): Int = {
    if (num <= 0 && deNum > 0) compute(1, deNum, newNum, newDeNum)
    else if (num > 0 && deNum <= 0) compute(num, 1, newNum, newDeNum)
    else if (num <= 0 && deNum <= 0) newNum / newDeNum
    else compute(num - 1, deNum - 1, num * newNum, deNum * newDeNum)
  }

}
