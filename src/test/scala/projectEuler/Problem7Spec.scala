package projectEuler

import org.scalatest.{FunSpec, Matchers}
import org.scalatest.prop.TableDrivenPropertyChecks._

import Problem7._

class Problem7Spec extends FunSpec with Matchers {

  describe("nthPrimeNumber") {

    val scenarios = Table(
      ("N", "expectedNthPrimeNumber"),
      (6, 13),
      (10001, 104743)
    )

    forAll(scenarios) { (N: Int, expectedNthPrimeNumber: Int) =>
      it(s"should return $expectedNthPrimeNumber as the ${N}th prime number") {
        nthPrimeNumber(N) should equal(expectedNthPrimeNumber)
      }
    }
  }
}
