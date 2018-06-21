package hackerRank.sampleTest

import testUtils.TestFixture
import Test2._

class Test2Spec extends TestFixture {

  describe("Odd Numbers!") {

    describe("oddNumbers") {

      val scenarios = Table(
        ("bounds", "expectedOddNumbers"),
        ((2, 5), Array(3, 5)),
        ((3, 9), Array(3, 5, 7, 9))
      )

      forAll(scenarios) { (bounds, expectedOddNumbers) =>
        it(s"should return $expectedOddNumbers as the odd numbers between $bounds") {
          oddNumbers(bounds._1, bounds._2) shouldBe expectedOddNumbers
        }
      }
    }
  }
}
