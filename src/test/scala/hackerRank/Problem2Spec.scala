package hackerRank

import Problem2._
import testUtils.TestFixture

class Problem2Spec extends TestFixture {

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
