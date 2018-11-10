package hackerRank

import testUtils.TestFixture
import Problem8._

class Problem8Spec extends TestFixture {

  describe("Heaps: Find the Running Median") {

    describe("runningMedian") {

      val scenarios = Table(
        ("array", "expectedRunningMedian"),
        (Vector.empty[Int], 0D)
      )

      forAll(scenarios) { (array, expectedRunningMedian) =>
        it(s"should return $expectedRunningMedian as the running median of ${array.mkString(", ")}") {
          runningMedian(array) shouldBe expectedRunningMedian
        }
      }
    }
  }
}
