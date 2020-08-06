package projectEuler

import projectEuler.Problem5._
import testUtils.TestFixture

class Problem5Spec extends TestFixture {

  describe("smallestMultiple") {

    val scenarios = Table(
      ("smallestDivisor", "largestDivisor", "smallestMultiple"),
      (1, 10, 2520),
      (1, 20, 232792560)
    )

    forAll(scenarios) { (smallestDivisor: Int, largestDivisor: Int, smallestMultiple: Int) =>
      it(s"should return $smallestMultiple as the smallest multiple that divisible by all numbers from $smallestDivisor to $largestDivisor without any remainder") {
        computeSmallestMultiple(smallestDivisor, largestDivisor) should equal(smallestMultiple)
      }
    }
  }
}
