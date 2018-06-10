package random

object ClosestCommonManager {

  val bill = Employee(1, "Bill", Nil)

  val dom = Employee(2, "Dom", Seq(bill))
  val samir = Employee(3, "Samir", Seq(bill))
  val michael = Employee(4, "Michael", Seq(bill))

  val peter = Employee(5, "Peter", Seq(dom))
  val bob = Employee(6, "Bob", Seq(dom))
  val porter = Employee(7, "Porter", Seq(dom))

  val milton = Employee(8, "Milton", Seq(peter))
  val nina = Employee(9, "Nina", Seq(peter))

  def getClosestCommonManager(employees: Seq[Employee]): Employee = {
    val managers = employees.map(employee => getManagers(employee, employee.reportsTo))
    val commonManagers = managers.flatten.groupBy(_.id)
    commonManagers(commonManagers.keySet.min).head
  }

  private def getManagers(employee: Employee, managers: Seq[Employee]): Seq[Employee] = {
    if (employee.reportsTo.isEmpty) managers
    else {
      val lineManagers = employee.reportsTo
      lineManagers.flatMap(employee => getManagers(employee, managers))
    }
  }

}

case class Employee(id: Int, name: String, reportsTo: Seq[Employee])
