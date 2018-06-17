package hackerRank

import utils.IsTrue

import scala.collection.mutable

object Problem7 {

  case class Node(data: Int, left: Option[Node] = None, right: Option[Node] = None)

  def checkBST(tree: Node): IsTrue.Value = {
    val seenElems = mutable.Set.empty[Int]

    val rootData = tree.data
    val left = check(rootData, tree.left, isGreaterThan(rootData), seenElems)
    val right = check(rootData, tree.right, isLessThan(rootData), seenElems)
    val leftIsNotBST = left.contains(IsTrue.No)
    val rightIsNotBST = right.contains(IsTrue.No)

    if (!leftIsNotBST && !rightIsNotBST)
      IsTrue.Yes
    else
      IsTrue.No
  }

  private def isGreaterThan(x: Int)(y: Int): Boolean = x > y
  private def isLessThan(x: Int)(y: Int): Boolean = x < y

  private def check(rootData: Int, tree: Option[Node], op: Int => Boolean, seenElems: mutable.Set[Int], isBST: IsTrue.Value = IsTrue.Yes): Vector[IsTrue.Value] = {
    tree match {
      case Some(Node(data, left, right)) =>
        if (seenElems.contains(data) || !op(data))
          Vector(IsTrue.No)
        else {
          seenElems += data
          check(rootData, left, op, seenElems, isBST) ++ check(rootData, right, op, seenElems, isBST)
        }
      case None => Vector(isBST)
    }
  }

}
