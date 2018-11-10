//package hackerRank
//
//import hackerRank.Problem9.Operation
//import hackerRank.Problem9.OperationType.{add, find}
//import testUtils.TestFixture
//
//class Problem9BSpec extends TestFixture {
//
//  describe("Tries: Contacts") {
//
//    describe("contacts") {
//
//      val scenarios = Table(
//        ("operations", "expectedResult"),
//        (Vector(Operation(add, "hact"), Operation(add, "hackerrank"), Operation(find, "hac")), Vector(2)),
//        (Vector(Operation(add, "hack"), Operation(add, "hackerrank"), Operation(find, "hac"), Operation(find, "hak")), Vector(1, 0)),
//        (Vector(Operation(add, "hack"), Operation(add, "hackerrank"), Operation(find, "hak")), Vector(0))
//      )
//
//      forAll(scenarios) { (operations, expectedResult) =>
//        it(s"should return $expectedResult as the number of contacts given $operations") {
//          contact(operations) should contain theSameElementsInOrderAs expectedResult
//        }
//      }
//    }
//  }
//}
