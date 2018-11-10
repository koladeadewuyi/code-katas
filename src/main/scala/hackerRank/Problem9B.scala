//package hackerRank
//
//import scala.collection.mutable
//
//object Problem9 {
//
//  object OperationType extends Enumeration {
//    type OperationType = Value
//    val add, find  = Value
//  }
//
//  case class Operation(`type`: OperationType.Value, arg: String)
//
//  def contact(operations: Vector[Operation]): Vector[Int] = {
//    performOperation(operations, new Contacts())
//  }
//
//  val contacts = mutable.Map[String, []]
//
//  private def performOperation(operations: Vector[Operation], contacts: Contacts, results: Vector[Int] = Vector.empty[Int]): Vector[Int] = {
//    if (operations.isEmpty) results
//    else {
//      operations.head match {
//        case Operation(OperationType.add, entry) =>
//          contacts.insert(entry)
//          performOperation(operations.tail, contacts, results)
//        case Operation(OperationType.find, query) =>
//          val occurrences = contacts.get(query).map(_.contacts.count(_ => true)).getOrElse(0)
//          performOperation(operations.tail, contacts, results :+ occurrences)
//        case unexpected =>
//          throw new IllegalArgumentException(s"Unexpected operation $unexpected")
//      }
//    }
//  }
//
//}
