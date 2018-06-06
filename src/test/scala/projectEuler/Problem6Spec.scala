package projectEuler

import org.scalatest.{FunSpec, Matchers}
import org.scalatest.prop.TableDrivenPropertyChecks._

import Problem6._

class Problem6Spec extends FunSpec with Matchers {

  describe("sumSquaresDifference") {

    val scenarios = Table(
      ("nFirstNumbers", "expectedSumOfSquareDifference"),
      (10, 2640d),
      (100, 25164150d)
    )

    forAll(scenarios) { (nFirstNumbers: Int, expectedSumOfSquareDifference: Double) =>
      it(s"should return $expectedSumOfSquareDifference as the difference between the sum of squares of the $nFirstNumbers and the square of the sum") {
        sumSquaresDifference(nFirstNumbers) should equal(expectedSumOfSquareDifference)
      }
    }
  }
}
