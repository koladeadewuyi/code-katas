package hackerRank

import scala.annotation.tailrec
import scala.collection.mutable

object Problem9A {

  object OperationType extends Enumeration {
    type OperationType = Value
    val add, find  = Value
  }

  case class ContactNode(value: Char) extends Contacts

  class Contacts {

    private var prefixCount = 0
    private var completeCount = 0

    val contacts: mutable.Map[Char, Contacts] = mutable.Map[Char, Contacts]()

    @tailrec
    final def insert(entry: String): Unit = {
      entry.headOption match {
        case Some(head) =>
          prefixCount += 1
          contacts.get(head) match {
            case Some(children) =>
              children.insert(entry.tail)
            case _ =>
              contacts += (head -> ContactNode(head))
              contacts(head).insert(entry.tail)
          }
        case _ => completeCount += 1
      }
    }

    @tailrec
    final def get(query: String): Option[Contacts] = {
      if (query.isEmpty) Option(this)
      else {
        contacts.get(query.head) match {
          case Some(contact) => contact.get(query.tail)
          case _ => None
        }
      }
    }

    def getCompleteCount: Int = completeCount
    def getPrefixCount: Int = prefixCount
    def getCount: Int = completeCount + prefixCount

  }

  case class Operation(`type`: OperationType.Value, arg: String)

  def contact(operations: Vector[Operation]): Vector[Int] = {
    performOperation(operations, new Contacts())
  }

  private def performOperation(operations: Vector[Operation], contacts: Contacts, results: Vector[Int] = Vector.empty[Int]): Vector[Int] = {
    if (operations.isEmpty) results
    else {
      operations.head match {
        case Operation(OperationType.add, entry) =>
          contacts.insert(entry)
          performOperation(operations.tail, contacts, results)
        case Operation(OperationType.find, query) =>
          val occurrences = contacts.get(query).map(_.getCount).getOrElse(0)
          performOperation(operations.tail, contacts, results :+ occurrences)
        case unexpected =>
          throw new IllegalArgumentException(s"Unexpected operation $unexpected")
      }
    }
  }

}
