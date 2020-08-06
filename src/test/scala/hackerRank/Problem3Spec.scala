package hackerRank

import Problem3._
import testUtils.TestFixture
import utils.IsTrue._

class Problem3Spec extends TestFixture {

  private val BlankSpace = " "

  describe("Hash Tables: Ransom Note") {

    describe("checkMagazine") {

      val scenarios = Table(
        ("magazineString", "noteString", "containsNote"),
        ("give me one grand today night", "give one grand today", Yes),
        ("Attack at dawn", "attack at dawn", No), // Case sensitive
        ("two times three is not four", "two times two is four", No)
      )

      forAll(scenarios) { (magazineString, noteString, containsNote) =>
        it(s"should return $containsNote as the result when '$noteString' is checked in '$magazineString'") {
          val magazine = magazineString.split(BlankSpace)
          val note = noteString.split(BlankSpace)

          checkMagazine(magazine, note) shouldBe containsNote
        }
      }
    }
  }
}
