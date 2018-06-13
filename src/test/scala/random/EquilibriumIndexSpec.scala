package random

import org.scalatest.{FunSpec, Matchers}
import org.scalatest.prop.TableDrivenPropertyChecks._

import EquilibriumIndex._

class EquilibriumIndexSpec extends FunSpec with Matchers {

  describe("getEquilibriumIndices") {

    val scenarios = Table(
      ("listOfNumbers", "equilibriumIndices"),
      (List(-7, 1, 5, 2, -4, 3, 0), List(3, 6))
    )

    forAll(scenarios) { (listOfNumbers, indicesOfSymmetricalSums) =>
      it(s"should return ${indicesOfSymmetricalSums.mkString(",")} as the equilibrium indices when given ${listOfNumbers.mkString(",")}") {
        getEquilibriumIndices(listOfNumbers) should contain theSameElementsAs indicesOfSymmetricalSums
      }
    }
  }
}
