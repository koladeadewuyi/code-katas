import scala.io.StdIn._
import scala.annotation.tailrec

case class Query(`type`: Int, arg: Option[Int] = None)

object MyApp {

  val Enqueue = 1
  val Dequeue = 2
  val Print = 3

  def main(args: Array[String]): Unit = {

    val numOfQueries = readLine().trim.toInt

    val queries: Vector[Query] = for {
      _ <- (1 to numOfQueries).toVector
      input <- Option(readLine())
      if input.nonEmpty
    } yield {
      input.split(" ").map(_.trim.toInt).toVector match {
        case Vector(operation) if Set(Print, Dequeue).contains(operation) => Query(operation, None)
        case Vector(operation, arg) if operation == Enqueue => Query(operation, Option(arg))
        case invalidInputs =>
          throw new IllegalArgumentException(s"Unable to build query from user input ${invalidInputs.mkString(",")}")
      }

    }

    processQueries(queries).foreach(println(_))
  }

  private def processQueries(queries: Vector[Query]): Seq[Int] = {
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
