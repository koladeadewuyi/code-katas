package random

import testUtils.TestFixture
import SentenceTransFormer._

class SentenceTranFormerSpec extends TestFixture {

    describe("transFormWords") {

      val scenarios = Table(
        ("words", "result"),
        (Seq("AB", "CD"), Seq("AC", "AD", "BC", "BD")),
        (Seq("ABCD", "EF"), Seq("AE", "AF", "BE", "BF", "CE", "CF", "DE", "DF")),
        (Seq("ABC", "DEFGH"), Seq("AD", "AE", "AF", "AG", "AH", "BD", "BE", "BF", "BG", "BH", "CD", "CE", "CF", "CG", "CH"))
      )

      forAll(scenarios) { (words, result) =>
        it(s"should return ${result.mkString(", ")} when given ${words.mkString(", ")}") {
          transFormWords(words) should contain theSameElementsAs result
        }
      }
    }
}
