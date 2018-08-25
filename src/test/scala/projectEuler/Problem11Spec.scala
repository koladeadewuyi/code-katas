package projectEuler

import org.scalatest.prop.TableDrivenPropertyChecks._
import org.scalatest.{FunSpec, Matchers}
import projectEuler.Problem11._

import scala.language.implicitConversions

class Problem11Spec extends FunSpec with Matchers {

  describe("LargestProductOfGrid") {

    val threeByThreeMatrix: Vector[Vector[Short]] = Vector(
      Vector(1, 2, 3),
      Vector(4, 5, 6),
      Vector(7, 8, 9)
    )

    val oneByThreeMatrix: Vector[Vector[Short]] = Vector(
      Vector(1, 2, 3)
    )

    val scenarios = Table(
      ("matrix", "numOfAdjacentNumbers", "largestProduct"),
//      (threeByThreeMatrix, 2, 72),
      (oneByThreeMatrix, 2, 6)
    )

    describe("largestProductInGrid") {
      forAll(scenarios) { (matrix, numOfAdjacentNumbers, largestProduct) =>
        it(s"""should yield $largestProduct as the largest product of $numOfAdjacentNumbers
             |in same direction (up, down, left, right, or diagonally) given ${matrix.length}""".stripMargin) {
          largestProductInGrid(matrix, numOfAdjacentNumbers) shouldBe largestProduct
        }
      }
    }
  }

}
