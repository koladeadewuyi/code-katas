package random

import IdentifyingDuplicates._
import testUtils.TestFixture

import scala.collection.immutable.SortedSet

class IdentifyingDuplicatesSpec extends TestFixture {

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
