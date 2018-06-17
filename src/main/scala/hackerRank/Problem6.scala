package hackerRank

import scala.annotation.tailrec

object Problem6 {

  val Enqueue = 1
  val Dequeue = 2
  val Print = 3

  case class Query(`type`: Int, arg: Option[Int] = None)

  def processQueries(queries: Vector[Query]): Any = {
    require(queries.nonEmpty)
    process(queries)
  }

  @tailrec
  private def process(queries: Vector[Query], queue: Vector[Int] = Vector.empty, result: Vector[Int] = Vector.empty): Seq[Int] = {
    if (queries.isEmpty) result
    else {
      val (elemOpt, updatedQueue) = queries.head match {
        case Query(Enqueue, Some(x)) =>
          (None, queue :+ x)
        case Query(Dequeue, None) =>
          (None, queue.tail)
        case Query(Print, None) =>
          (queue.headOption, queue)
        case invalidOperation => throw new IllegalArgumentException(s"Invalid operation $invalidOperation")
      }
      val updatedResults = elemOpt.map(elem => result :+ elem).getOrElse(result)
      process(queries.tail, updatedQueue, updatedResults)
    }
  }

}
