package projectEuler

import projectEuler.Problem3._
import org.scalatest.{FunSpec, Matchers}
import org.scalatest.prop.TableDrivenPropertyChecks._

/**
 * Created by koladeadewuyi@gmail.com on 26/12/2016.
 */
class Problem3Spec extends FunSpec with Matchers {

  describe("largestPrimeFactors") {

    val scenarios = Table(
      ("number", "largest prime factors"),
      (13195l, 29l),
      (600851475143l, 6857l),
      (1600851475143l, 16807369l),
      (700600851475143l, 8052883350289l)
    )

    forAll(scenarios) { (number: Long, expected: Long) =>
      it(s"should return $expected as the largest prime factor of $number") {
        largestPrimeFactor(number) should equal(expected)
      }
    }
  }
}
