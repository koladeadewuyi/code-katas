package random

import org.scalatest.{FunSpec, Matchers}
import org.scalatest.prop.TableDrivenPropertyChecks._
import IdentifyingDuplicates._

import scala.collection.immutable.SortedSet

class IdentifyingDuplicatesSpec extends FunSpec with Matchers {

  describe("findDuplicates") {

    val scenarios = Table(
      ("listOfNumbers", "duplicates"),
      (List(1, 2, 3, 1, 3, 6, 6), SortedSet(1, 3, 6))
    )

    forAll(scenarios) { (listOfNumbers, duplicates) =>
      it(s"should return ${duplicates.mkString(",")} as the duplicates when given ${listOfNumbers.mkString(",")}") {
        findDuplicates(listOfNumbers) should contain theSameElementsAs duplicates
      }
    }
  }
}
