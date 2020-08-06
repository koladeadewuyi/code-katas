package leetCode

import RegexMatch._
import testUtils.TestFixture

class RegexMatchSpec extends TestFixture {

  val scenarios = Table(
    ("string", "pattern", "matches"),
    ("aa", "a", false),
    ("aa", "a*", true),
    ("ab", ".*", true),
    ("aab", "c*a*b", true),
    ("mississippi", "mis*is*p*.", false)
  )

  describe("RegexMatch") {
    forAll(scenarios) { (string, pattern, matches) =>
      it(s"should return $matches when applying a pattern $pattern to $string") {
        isMatch(string, pattern) shouldBe matches
      }
    }
  }

}
