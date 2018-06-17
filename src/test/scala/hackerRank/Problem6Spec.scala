package hackerRank

import testUtils.TestFixture
import Problem6._

class Problem6Spec extends TestFixture {

  describe("Queues: A Tale of Two Stacks") {

    describe("processQueries") {

      val scenarios = Table(
        ("queries", "expectedResult"),
        (Vector(Query(Enqueue, Some(42)), Query(Dequeue), Query(Enqueue, Some(14)), Query(Print), Query(Enqueue, Some(28)), Query(Print), Query(Enqueue, Some(60)), Query(Enqueue, Some(78)), Query(Dequeue), Query(Dequeue)), Seq(14, 14)),
        (Vector(Query(Enqueue, Some(15)), Query(Enqueue, Some(17)), Query(Print), Query(Enqueue, Some(25)), Query(Dequeue), Query(Print), Query(Dequeue), Query(Print)), Seq(15, 17, 25))
      )

      forAll(scenarios) { (queries, expectedResult) =>
        it(s"should return $expectedResult when given $queries") {
          processQueries(queries) shouldBe expectedResult
        }
      }
    }
  }
}
