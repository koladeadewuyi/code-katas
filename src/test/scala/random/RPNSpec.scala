package random

import testUtils.TestFixture

class RPNSpec extends TestFixture {

  describe("RPN") {

    describe("generateHPF") {

      val scenarios = Table(
        ("input", "result"),
        ("1 ++", "(1++)"),
        ("1 2 +", "(1+2)"),
        ("1 2 3 + -", "(1-(2+3))"),
        ("1 2 - 3 4 + -", "((1-2)-(3+4))"),
        ("2 1 + 3 *", "((2+1)*3)"),
        ("4 13 5 / +", "(4+(13/5))"),
        ("10 6 9 3 + -11 * / * 17 + 5 +", "(((10*(6/((9+3)*-11)))+17)+5)")
      )

      forAll(scenarios) { (input, result) =>
        it(s"should return $result when given $input") {
          RPN.generateHPF(input) shouldBe result
        }
      }
    }

    describe("evaluateRPN") {

      val scenarios = Table(
        ("input", "result"),
        ("1 ++", 2),
        ("1 2 +", 3),
        ("1 2 3 + -", -4),
        ("1 2 - 3 4 + -", -8),
        ("2 1 + 3 *", 9),
        ("4 13 5 / +", 6),
        ("10 6 9 3 + -11 * / * 17 + 5 +", 22)
      )

      forAll(scenarios) { (input, result) =>
        it(s"should return $result as the result of evaluating $input") {
          RPN.evaluateRPN(input) shouldBe result
        }
      }
    }
  }
}
