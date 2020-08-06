package projectEuler

import Problem10._
import testUtils.TestFixture

class Problem10Spec extends TestFixture {

  describe("sumOfPrimes") {

    val scenarios = Table(
      ("number", "expectedSumOfPrimes"),
      (10, 17),
      (2000000, 142913828922L)
    )

    forAll(scenarios) { (number, expectedSumOfPrimes) =>
      it(s"should return $expectedSumOfPrimes as the sum of primes below $number") {
        val result = sumOfPrimesBelow(number)
        result shouldBe expectedSumOfPrimes
      }
    }
  }

}
