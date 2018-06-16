package hackerRank

import org.scalatest.{FunSpec, Matchers}
import org.scalatest.prop.TableDrivenPropertyChecks
import Problem1._

class Problem1Spec extends FunSpec with Matchers with TableDrivenPropertyChecks {

  describe("Arrays: Left Rotation") {

    describe("rotLeft") {

      val scenarios = Table(
        (
          "array",
          "numberOfRotations",
          "expectedResult"
        ),
        (Seq(1, 2, 3, 4, 5),
          4,
          Seq(5, 1, 2, 3, 4)
        ),
        (
          Seq(41, 73, 89, 7, 10, 1, 59, 58, 84, 77, 77, 97, 58, 1, 86, 58, 26, 10, 86, 51),
          10,
          Seq(77, 97, 58, 1, 86, 58, 26, 10, 86, 51, 41, 73, 89, 7, 10, 1, 59, 58, 84, 77)
        )
      )

      forAll(scenarios) { (array, numberOfRotations, expectedResult) =>
        it(s"should return ${expectedResult.mkString(", ")} as the result of rotating ${array.mkString(", ")} $numberOfRotations times to the left") {
          val actualResult = rotLeft(array, numberOfRotations)

          actualResult should contain theSameElementsInOrderAs expectedResult
        }
      }
    }
  }
}
