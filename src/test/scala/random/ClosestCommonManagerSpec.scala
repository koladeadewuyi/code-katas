package random

import org.scalatest.{FunSpec, Matchers}
import org.scalatest.prop.TableDrivenPropertyChecks
import ClosestCommonManager._

class ClosestCommonManagerSpec extends FunSpec with Matchers with TableDrivenPropertyChecks {

  describe("closestCommonManager") {

    val scenarios = Table(
      ("closestCommonManager", "employees"),
      (peter, Seq(milton, nina)),
      (dom, Seq(nina, porter)),
      (bill, Seq(nina, samir)),
      (dom, Seq(peter, nina))
    )

    forAll(scenarios) { (closestCommonManager, employees) =>
      it(s"should return ${closestCommonManager.name} as the closest common manager for ${employees.map(_.name).mkString(", ")}") {
        getClosestCommonManager(employees) shouldBe closestCommonManager
      }
    }

  }

}
