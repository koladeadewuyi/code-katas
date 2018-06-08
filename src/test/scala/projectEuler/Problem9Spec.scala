package projectEuler

import org.scalatest.{FunSpec, Matchers}
import org.scalatest.prop.TableDrivenPropertyChecks._

import Problem9._

class Problem9Spec extends FunSpec with Matchers {

  describe("specialPythagoreanTriplet") {

    val scenarios = Table(
      ("triplet", "sum"),
      ((3, 4, 5), 12),
      ((375, 200, 425), 1000)
    )

    case class User(name: String, age: Float)

    forAll(scenarios) { (triplet, sum) =>
      it(s"should return $triplet as the pythagorean triplet that sum up to $sum") {
        val result = specialPythagoreanTriplet(sum, Math.sqrt(sum).toInt)
        result._1 should equal(triplet._1)
        result._2 should equal(triplet._2)
        result._3 should equal(triplet._3)
      }
    }
  }
}
