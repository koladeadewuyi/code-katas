package random

import testUtils.TestFixture
import Permutation._

class PermutationSpec extends TestFixture {

  describe("permutation") {

    val scenarios = Table(
      ("n", "r", "result"),
      (3, 1, 3),
      (5, 2, 20),
      (10, 4, 5040)
    )

    forAll(scenarios) { (n, r, result) =>
      it(s"should return $result when n = $n and r = $r") {
        permutation(n, r) shouldBe result
      }
    }
  }

}
