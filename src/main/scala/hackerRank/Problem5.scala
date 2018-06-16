package hackerRank

import utils.IsTrue

import scala.annotation.tailrec

object Problem5 {

  private val BracketMapping = Map('[' -> ']', '{' -> '}', '(' -> ')')
  private val OpeningBrackets = BracketMapping.keySet
  private val ClosingBrackets = BracketMapping.values.toSet

  def hasBalancedBrackets(expression: String): IsTrue.Value = {
    require(expression.length >= 1 && expression.length <= math.pow(10, 3))
    if (expression.length % 2 != 0) IsTrue.No
    else check(expression.tail, List(expression.head))
  }

  @tailrec
  private def check(expression: String, stack: List[Char]): IsTrue.Value = {
    if (expression.isEmpty && stack.isEmpty) IsTrue.Yes
    else if (expression.nonEmpty && stack.isEmpty) check(expression.tail, List(expression.head))
    else if (expression.isEmpty && stack.nonEmpty) IsTrue.No
    else {
      val head = expression.head
      if (OpeningBrackets(stack.head) && (OpeningBrackets(head) || ClosingBrackets(head))) {
        if (head == BracketMapping(stack.head)) {
          check(expression.tail, stack.tail)
        } else {
          check(expression.tail, head +: stack)
        }
      } else {
        IsTrue.No
      }
    }
  }

}
