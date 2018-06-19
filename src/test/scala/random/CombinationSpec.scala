package random

import random.Combination._
import testUtils.TestFixture

class CombinationSpec extends TestFixture {

  describe("combination") {

    val scenarios = Table(
      ("n", "r", "result"),
      (3, 1, 3),
      (3, 2, 3),
      (3, 3, 1),
      (4, 1, 4),
      (4, 2, 6),
      (4, 3, 4),
      (4, 4, 1)
    )

    forAll(scenarios) { (n, r, result) =>
      it(s"should return $result when n = $n and r = $r") {
        combination(n, n - r) shouldBe result
      }
    }
  }

}
