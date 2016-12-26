package projectEuler

import projectEuler.Problem1._
import org.scalatest.{Matchers, FunSpec}
import org.scalatest.prop.TableDrivenPropertyChecks._

/**
 * Created by koladeadewuyi@gmail.com on 26/12/2016.
 */
class Problem1Spec extends FunSpec with Matchers {

  describe("sumOfMultiples") {

    val scenarios = Table(
      ("number", "divisors", "sum of multiples of divisors"),
      (10, List(3, 5), 23),
      (1000, List(3, 5), 233168),
      (1000, List.empty, 0),
      (0, List(3, 5), 0),
      (-100, List(3, 5), 0),
      (-100, List.empty, 0)
    )

    forAll(scenarios) { (number: Int, divisors: List[Int], sum: Int) =>
      it(s"should return $sum as the sum of multiples of ${divisors.mkString(",")} below $number") {
        sumOfMultiples(number, divisors) should equal(sum)
      }

    }
  }
}
