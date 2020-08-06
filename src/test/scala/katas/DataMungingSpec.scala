package katas

import katas.DataMunging._
import testUtils.TestFixture

/**
 * Created by koladeadewuyi@gmail.com on 18/12/2016.
 */
class DataMungingSpec extends TestFixture with DataFileExtractor {

  describe("find") {

    val scenarios = Table(
      ("dataFileName", "expectedValue"),
      ("weather.dat", "14"),
      ("football.dat", "Newcastle")
    )

    forAll(scenarios) { (dataFileName, expectedValue) =>
      it(s"should return $expectedValue as the result when given file $dataFileName") {
        val list: List[Data] = convertFileToList(dataFileName)
        find(list)._1 shouldBe expectedValue
      }
    }
  }

}


