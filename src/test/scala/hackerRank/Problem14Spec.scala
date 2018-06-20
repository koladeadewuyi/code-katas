package hackerRank

import testUtils.TestFixture
import Problem14._

class Problem14Spec extends TestFixture {

  describe("Hash Tables: Ice Cream Parlor") {

    describe("whatFlavors") {

      val scenarios = Table(
        ("cost", "money", "purchased"),
        (Vector(1, 4, 5, 3, 2), 4, Vector(1, 4)),
        (Vector(2, 2, 4, 3), 4, Vector(1, 2))
      )

      forAll(scenarios) { (cost, money, purchased) =>
        it(s"should return $purchased as the items bought among $cost given money $money") {
          whatFlavors(cost, money) shouldBe purchased
        }
      }
    }
  }
}
