package hackerRank

import testUtils.TestFixture
import Problem11._

class Problem11Spec extends TestFixture {

  describe("Recursion: Davis' Staircase") {

    describe("stepPerms") {
      val scenarios = Table(
        ("numberOfStairs", "numberOfWaysToClimb"),
        (0, 1),
        (1, 1),
        (3, 4),
        (4, 8),
        (5, 16),
        (7, 44)
      )

      forAll(scenarios) { (numberOfStairs, expectedNumberOfWaysToClimb) =>
        it(s"should return $expectedNumberOfWaysToClimb as the possible ways of climbing $numberOfStairs stairs") {
          stepPerms(numberOfStairs) shouldBe expectedNumberOfWaysToClimb
        }
      }
    }
  }
}
