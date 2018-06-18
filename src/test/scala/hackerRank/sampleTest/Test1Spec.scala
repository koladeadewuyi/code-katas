package hackerRank.sampleTest

import testUtils.TestFixture
import utils.IsTrue._
import Test1._

class Test1Spec extends TestFixture {

  describe("Find the number!") {

    describe("findNumber") {

      val scenarios = Table(
        ("array", "item", "isPresent"),
        (Array(5, 1, 2, 3, 4, 5), 1, Yes),
        (Array(3, 2, 3, 1), 5, No)
      )

      forAll(scenarios) { (array, item, isPresent) =>
        it(s"should return $isPresent when finding $item in $array") {
          findNumber(array, item) shouldBe isPresent
        }
      }
    }
  }
}
