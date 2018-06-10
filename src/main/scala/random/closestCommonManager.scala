package random

object ClosestCommonManager {

  val milton = Employee(8, "Milton", Nil)
  val nina = Employee(9, "Nina", Nil)

  val bob = Employee(6, "Bob", Nil)
  val porter = Employee(7, "Porter", Nil)
  val peter = Employee(5, "Peter", Seq(milton, nina))

  val dom = Employee(2, "Dom", Seq(peter, bob, porter))
  val samir = Employee(3, "Samir", Nil)
  val michael = Employee(4, "Michael", Nil)

  val bill = Employee(1, "Bill", Seq(dom, samir, michael))

  def getClosestCommonManager(employees: Seq[Employee]): Employee = {
    val employeesManagers = employees.map(employee => getManagers(bill, employee, Seq(bill)).toSet)
    val commonManagers = employeesManagers.reduce(_ intersect _)
    commonManagers.toSeq.maxBy(_.id)
  }

  private def getManagers(manager: Employee, employee: Employee, managers: Seq[Employee]): Seq[Employee] = {
    val subordinates = manager.subordinates
    if (subordinates.isEmpty) managers
    else {
      if (subordinates.contains(employee)) managers :+ manager
      else subordinates.flatMap(subordinate => getManagers(subordinate, employee, managers :+ manager))
    }
  }

}

case class Employee(id: Int, name: String, subordinates: Seq[Employee])
