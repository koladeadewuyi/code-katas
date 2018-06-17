package hackerRank

import testUtils.TestFixture
import utils.IsTrue._
import Problem7._

class Problem7Spec extends TestFixture {

  describe("Trees: Is This a Binary Search Tree?") {

    describe("checkBST") {

      val scenarios = Table(
        ("tree", "isBST"),
        (Node(3, Some(Node(4)), Some(Node(5))), No), // left subtree contains elem (4) greater than root (3)
        (Node(3, Some(Node(2)), Some(Node(1))), No), // right subtree contains elem (1) less than root (3)
        (Node(3, Some(Node(2, Some(Node(1)))), Some(Node(4, Some(Node(5)), Some(Node(6))))), Yes),
        (Node(4, Some(Node(2, Some(Node(1)), Some(Node(3)))), Some(Node(6, Some(Node(5)), Some(Node(7))))), Yes),
        (Node(3, Some(Node(2, Some(Node(1)))), Some(Node(5, Some(Node(6)), Some(Node(1))))), No) // 1 is duplicated
      )

      forAll(scenarios) { (tree, isBST) =>
        it(s"should return $isBST when given $tree") {
          checkBST(tree) shouldBe isBST
        }
      }
    }
  }
}
