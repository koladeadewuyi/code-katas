package projectEuler

import projectEuler.Problem2._
import org.scalatest.{FunSpec, Matchers}
import org.scalatest.prop.TableDrivenPropertyChecks._

/**
 * Created by koladeadewuyi@gmail.com on 26/12/2016.
 */
class Problem2Spec extends FunSpec with Matchers {

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
