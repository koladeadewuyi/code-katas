package katas

/**
 * Created by koladeadewuyi@gmail.com on 08/12/2016.
 */

import katas.SummablePairs._
import org.scalatest.prop.TableDrivenPropertyChecks._
import org.scalatest.{FunSpec, Matchers}

class SummablePairsSpec extends FunSpec with Matchers {

  describe("find") {

    val scenarios = Table(
      ("expectedResult", "array", "sum"),
      (List.empty, Array(), 3),
      (List.empty, Array(1), 3),
      (List.empty, Array(1), 1),
      (List.empty, Array(1, 2, 3, 9), 8),
      (List((4, 4)), Array(1, 2, 4, 4), 8),
      (List((4, 4), (2, 6)), Array(1, 2, 4, 4, 6), 8),
      (List((4, 3), (2, 5)), Array(2, 4, 3, 5, 7, 8, 9), 7),
      (List((4, 3), (2, 5), (3, 4), (-2, 9)), Array(2, 4, 3, 5, 6, -2, 4, 7, 8, 9), 7),
      (List((0, 7), (4, 3), (0, 7)), Array(0, 14, 0, 4, 7, 8, 3, 5, 7), 7),
      (List((4, 7), (8, 3), (4, 7)), Array(0, 14, 0, 4, 7, 8, 3, 5, 7), 11),
      (List((10, 2), (2, 10)), Array(10, 9, 5, 9, 0, 10, 2, 10, 1, 9), 12)
    )

    forAll(scenarios) { (expectedResult: List[(Int, Int)], array: Array[_ <: Int], sum: Int) =>
      it(s"should return ${expectedResult.mkString(", ")} when given $sum and array [${array.mkString(", ")}]") {
        find(sum, array) should equal(expectedResult)
      }
    }

  }

}

