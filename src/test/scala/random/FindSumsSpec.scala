package random

import testUtils.TestFixture
import FindSums._

class FindSumsSpec extends TestFixture {

  describe("findSums") {

    val scenarios = Table(
      ("nums", "total", "sums"),
      (Seq(1, 15, 12, 8, 5, 11, 8, 3, 7), 10, Some(3, 7)),
      (Seq(1, 2, 3), 10, None)
    )

    forAll(scenarios) { (nums, total, sums) =>
      it(s"should return $sums as the result of finding two numbers in $nums which sum up to $total") {
        findSums(nums, total) shouldBe sums
      }
    }
  }

}
