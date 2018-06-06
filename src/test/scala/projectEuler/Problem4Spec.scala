package projectEuler

import projectEuler.Problem4._
import org.scalatest.{FunSpec, Matchers}
import org.scalatest.prop.TableDrivenPropertyChecks._

class Problem4Spec extends FunSpec with Matchers {

  describe("largestPalindromeProduct") {

    val scenarios = Table(
      ("numberOfDigits", "largestPalindromeProduct"),
      (2, 9009),
      (3, 906609)
    )

    forAll(scenarios) { (numberOfDigits: Int, expectedProduct: Int) =>
      it(s"should return $expectedProduct as the largest palindrome product that can be obtained from two $numberOfDigits digits numbers") {
        largestPalindromeProduct(numberOfDigits) should equal(expectedProduct)
      }
    }
  }
}
