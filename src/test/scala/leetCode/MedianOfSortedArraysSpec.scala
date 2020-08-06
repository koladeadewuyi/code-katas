package leetCode

import leetCode.MedianOfSortedArrays._
import testUtils.TestFixture

class MedianOfSortedArraysSpec extends TestFixture {

  describe("MedianOfSortedArrays") {

    val scenarios = Table(
      ("listA", "listB", "median"),
      (Array(1, 3), Array(2), 2.0),
      (Array(1, 2), Array(3, 4), 2.5)
    )

    forAll(scenarios) { (listA, listB, median) =>
      it(s"should return $median as the median of $listA and $listB") {
        findMedianSortedArrays(listA, listB) shouldBe median
      }
    }

  }

}
