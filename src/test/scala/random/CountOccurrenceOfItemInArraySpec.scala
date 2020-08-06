package random

import random.CountOccurrenceOfItemInArray._
import testUtils.TestFixture

class CountOccurrenceOfItemInArraySpec extends TestFixture {

  describe("countOccurrenceOfItem") {

    val scenarios = Table(
      ("array", "item", "count"),
      (Array.empty[Int], 1, 0),
      (Array(0, 0), 1, 0),
      (Array(1, 1, 1, 0, 0), 1, 3),
      (Array(1, 1, 1, 1, 1, 0, 0), 1, 5)
    )

    forAll(scenarios) { (array, item, count) =>
      it(s"should return $count as the number of occurrences of $item in ${array.mkString(",")}") {
        countOccurrenceOfItem(array, item) should equal(count)
      }
    }
  }
}
