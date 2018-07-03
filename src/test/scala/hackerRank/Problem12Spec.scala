package hackerRank

import testUtils.TestFixture
import Problem12._

class Problem12Spec extends TestFixture {

  describe("Recursion: Fibonacci Numbers") {

    describe("fibonacci") {

      val scenarios = Table(
        ("index", "expectedFibonacciNumber"),
        (3, 2),
        (4, 3),
        (5, 5),
        (6, 8),
        (12, 144),
        (100000000, 1819143227)
      )

      forAll(scenarios) { (index, expectedFibonacciNumber) =>
        it(s"should return $expectedFibonacciNumber as the ${index}th fibonacci number") {
          fibonacci(index) shouldBe expectedFibonacciNumber
        }
      }

    }
  }

}
