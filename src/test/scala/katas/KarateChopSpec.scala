package katas

/**
 * Created by koladeadewuyi@gmail.com on 08/12/2016.
 */

import katas.KarateChop._
import testUtils.TestFixture

class KarateChopSpec extends TestFixture {

  describe("chop") {

    val scenarios = Table(
      ("expectedResult", "array", "int"),
      (-1, Array(), 3),
      (-1, Array(1), 3),
      (0, Array(1), 1),
      (0, Array(1, 3, 5), 1),
      (1, Array(1, 3, 5), 3),
      (2, Array(1, 3, 5), 5),
      (-1, Array(1, 3, 5), 0),
      (-1, Array(1, 3, 5), 2),
      (-1, Array(1, 3, 5), 4),
      (-1, Array(1, 3, 5), 6),
      (0, Array(1, 3, 5, 7), 1),
      (1, Array(1, 3, 5, 7), 3),
      (2, Array(1, 3, 5, 7), 5),
      (3, Array(1, 3, 5, 7), 7),
      (-1, Array(1, 3, 5, 7), 0),
      (-1, Array(1, 3, 5, 7), 2),
      (-1, Array(1, 3, 5, 7), 4),
      (-1, Array(1, 3, 5, 7), 6),
      (-1, Array(1, 3, 5, 7), 8)
    )

    forAll(scenarios) { (expectedResult: Int, array: Array[_ <: Int], int: Int) =>
      it(s"should return $expectedResult when given $int and array [${array.mkString(", ")}]") {
        chop(int, array) should equal(expectedResult)
      }
    }

  }

}

