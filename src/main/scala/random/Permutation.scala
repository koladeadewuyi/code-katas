package random

object Permutation {

  def permutation(num: Int = 1, deNum: Int = 1, newNum: Int = 1, newDeNum: Int = 1): Int = {
    if (num <= 0 && deNum > 0) permutation(1, deNum, newNum, newDeNum)
    else if (num > 0 && deNum <= 0) permutation(num, 1, newNum, newDeNum)
    else if (num <= 0 && deNum <= 0) newNum / newDeNum
    else permutation(num - 1, deNum - 1, num * newNum, deNum * newDeNum)
  }

}
