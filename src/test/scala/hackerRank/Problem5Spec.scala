package hackerRank

import testUtils.TestFixture
import utils.IsTrue._
import Problem5._

class Problem5Spec extends TestFixture {

  describe("Stacks: Balanced Brackets") {

    describe("hasBalancedBrackets") {
      val scenarios = Table(
        ("expression", "isBalanced"),
        ("[", No),
        ("[{", No),
        ("{[()]}", Yes),
        ("{[(])}", No),
        ("{{[[(())]]}}", Yes),
        ("{()[][{}]}", Yes),
        ("({}{[]})({)}", No),
        ("()[]", Yes),
        ("[()][{}]{[({})[]]}", Yes),
        ("((){)}", No)
      )

      forAll(scenarios) { (expression, isBalanced) =>
        it(s"should return $isBalanced when given '$expression'") {
          hasBalancedBrackets(expression) shouldBe isBalanced
        }
      }
    }
  }
}
