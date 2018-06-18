package hackerRank

import testUtils.TestFixture
import Problem9A._
import Problem9A.OperationType._

class Problem9ASpec extends TestFixture {

  describe("Tries: Contacts") {

    describe("contacts") {

      val scenarios = Table(
        ("operations", "expectedResult"),
        (Vector(Operation(add, "hact"), Operation(add, "hackerrank"), Operation(find, "hac")), Vector(2)),
        (Vector(Operation(add, "hack"), Operation(add, "hackerrank"), Operation(find, "hac"), Operation(find, "hak")), Vector(2, 0)),
        (Vector(Operation(add, "hack"), Operation(add, "hackerrank"), Operation(find, "hak")), Vector(0))
      )

      forAll(scenarios) { (operations, expectedResult) =>
        it(s"should return $expectedResult as the number of contacts given $operations") {
          contact(operations) should contain theSameElementsInOrderAs expectedResult
        }
      }
    }
  }
}
