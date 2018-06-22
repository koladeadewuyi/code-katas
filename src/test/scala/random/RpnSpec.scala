package random

import testUtils.TestFixture

class RpnSpec extends TestFixture {

  describe("Rpn") {

    describe("generateHpf") {

      val scenarios = Table(
        ("input", "result"),
        ("1 ++", "(1++)"),
        ("1 2 +", "(1+2)"),
        ("1 2 3 + -", "(1-(2+3))"),
        ("1 2 - 3 4 + -", "((1-2)-(3+4))")
      )

      forAll(scenarios) { (input, result) =>
        it(s"should return $result when given $input") {
          Rpn.generateHpf(input) shouldBe result
        }
      }
    }
  }
}
