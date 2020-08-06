package projectEuler

import projectEuler.Problem1._
import testUtils.TestFixture

/**
 * Created by koladeadewuyi@gmail.com on 26/12/2016.
 */
class Problem1Spec extends TestFixture {

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

    forAll(scenarios) { (number, divisors, sum) =>
      it(s"should return $sum as the sum of multiples of '${divisors.mkString(",")}' below $number") {
        sumOfMultiples(number, divisors) should equal(sum)
      }

    }
  }
}
