package hackerRank

import testUtils.TestFixture
import Problem15._

class Problem15Spec extends TestFixture {

  // TODO: Resubmit this as other hidden test cases fail
  describe("Merge Sort: Counting Inversions") {

    describe("countInversions") {

      val scenarios = Table(
        ("array", "expectedNumberOfInversions"),
        (Vector(1, 1, 1, 2, 2), 0),
        (Vector(2, 1, 3, 1, 2), 4)
      )

      forAll(scenarios) { (array, expectedNumberOfInversions) =>
        it(s"should return $expectedNumberOfInversions, when sorting $array") {
          countInversions(array) shouldBe expectedNumberOfInversions
        }
      }
    }
  }

}
