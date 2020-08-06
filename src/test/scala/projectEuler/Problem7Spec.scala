package projectEuler

import Problem7._
import testUtils.TestFixture

class Problem7Spec extends TestFixture {

  describe("nthPrimeNumber") {

    val scenarios = Table(
      ("N", "expectedNthPrimeNumber"),
      (6, 13),
      (10001, 104743),
      (2000000, 104743)
    )

    forAll(scenarios) { (N: Int, expectedNthPrimeNumber: Int) =>
      it(s"should return $expectedNthPrimeNumber as the ${N}th prime number") {
        nthPrimeNumber(N) should equal(expectedNthPrimeNumber)
      }
    }
  }
}
