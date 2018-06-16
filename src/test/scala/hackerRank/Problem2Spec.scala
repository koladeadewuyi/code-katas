package hackerRank

import org.scalatest.{FunSpec, Matchers}
import org.scalatest.prop.TableDrivenPropertyChecks
import Problem2._

class Problem2Spec extends FunSpec with Matchers with TableDrivenPropertyChecks {

  describe("Strings: Making Anagrams") {

    describe("numOfCharsToDelete") {
      val scenarios = Table(
        ("stringA", "stringB", "expectedNumOfCharsToDelete"),
        ("cde", "abc", 4),
        ("ebfacdc", "gdcbhiac", 5)
      )

      forAll(scenarios) { (stringA, stringB, expectedNumOfCharsToDelete) =>
        it(s"should return $expectedNumOfCharsToDelete as the number of characters to delete to make $stringA and $stringB anagrams") {
          numOfCharsToDelete(stringA, stringB) shouldBe expectedNumOfCharsToDelete
        }
      }
    }
  }

}
