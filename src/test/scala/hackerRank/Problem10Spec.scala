package hackerRank

import testUtils.TestFixture
import Problem10._

class Problem10Spec extends TestFixture {

  describe("Sorting: Bubble Sort") {

    describe("countSwaps") {

      val scenarios = Table(
        ("array", "numberOfSwaps"),
//        (Vector.empty[Int], 0),
        (Vector(6, 4, 1), 3)
      )

      forAll(scenarios) { (array, numberOfSwaps) =>
        it(s"should return $numberOfSwaps as the number of swaps performed when sorting $array") {
          countSwaps(array) shouldBe numberOfSwaps
        }
      }
    }
  }
}
