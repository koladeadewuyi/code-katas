package hackerRank

import testUtils.TestFixture
import Problem13._

class Problem13Spec extends TestFixture {

  describe("Bit Manipulation: Lonely Integer") {

    describe("lonelyInteger") {

      val scenarios = Table(
        ("array", "expedtedLonelyInteger"),
        (Vector(1, 1, 2), 2),
        (Vector(0, 0, 1, 2, 1), 2)
      )

      forAll(scenarios) { (array, expedtedLonelyInteger) =>
        it(s"should return $expedtedLonelyInteger as the lonely integer in $array") {
          lonelyInteger(array) shouldBe expedtedLonelyInteger
        }
      }
    }
  }
}
