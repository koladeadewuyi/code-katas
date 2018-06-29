package leetCode

import RegexMatch._
import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.prop.TableDrivenPropertyChecks._

class RegexMatchSpec extends FlatSpec with Matchers {

  val scenarios = Table(
    ("string", "pattern", "matches"),
    ("aa", "a", false),
    ("aa", "a*", true),
    ("ab", ".*", true),
    ("aab", "c*a*b", true),
    ("mississippi", "mis*is*p*.", false)
  )

  forAll(scenarios) { (string, pattern, matches) =>
    "RegexMatch" should s"return $matches when applying a pattern $pattern to $string" in {
      isMatch(string, pattern) shouldBe matches
    }
  }

}
