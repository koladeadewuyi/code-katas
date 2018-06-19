package random

import org.scalatest.{FunSpec, Matchers}
import org.scalatest.prop.TableDrivenPropertyChecks._
import IdentifyMissingInteger._

import scala.collection.immutable.SortedSet

class IdentifyMissingIntegerSpec extends FunSpec with Matchers {

  describe("getMissingInteger") {

    val scenarios = Table(
      ("setOfIntegers", "missingInteger"),
      (SortedSet.empty[Int], None),
      (SortedSet(1, 2, 3), None),
      (SortedSet(1, 2, 4, 5), Some(3)),
      (SortedSet(1, 2, 3, 4, 6), Some(5))
    )

    forAll(scenarios) { (setOfIntegers, missingInteger) =>
      it(s"should identify $missingInteger as the missing integer when given ${setOfIntegers.mkString(",")}") {
        getMissingInteger(setOfIntegers) should equal(missingInteger)
      }
    }
  }
}
