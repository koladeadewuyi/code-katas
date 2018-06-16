package hackerRank

import hackerRank.Problem4._
import testUtils.TestFixture
import utils.IsTrue._

class Problem4Spec extends TestFixture {

  describe("Linked Lists: Detect a Cycle") {

    describe("hasCycle") {

      val scenarios = Table(
        ("list", "containsCycle"),
        (List.empty, No),
        (List(2), No),
        (List(1, 2, 3, 4), No),
        (List(1, 2, 3, 4, 1), Yes),
        (List(3, 7, 1, 4, 7, 9), Yes)
      )

      forAll(scenarios) { (list, containsCycle) =>
        it(s"should return $containsCycle when given linkedList $list") {
          hasCycle(list) shouldBe containsCycle
        }
      }
    }
  }

}
