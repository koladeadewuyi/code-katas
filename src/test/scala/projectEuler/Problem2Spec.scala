package projectEuler

import projectEuler.Problem2._
import testUtils.TestFixture

/**
 * Created by koladeadewuyi@gmail.com on 26/12/2016.
 */
class Problem2Spec extends TestFixture {

  describe("sumOfEvenFibonacciBelow") {

    val scenarios = Table(
      ("limit", "sum of even fibonacci numbers"),
      (10L, 10),
      (40L, 44),
      (4000000L, 4613732),
      (22000000000L, 26658145586L)
    )

    forAll(scenarios) { (limit, sum) =>
      it(s"should return $sum as the sum of even fibonacci numbers that do not exceed $limit") {
        sumOfEvenFibonacciBelow(limit) should equal(sum)
      }
    }

  }
}
