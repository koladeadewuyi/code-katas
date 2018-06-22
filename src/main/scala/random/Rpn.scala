package random

object Rpn {

  val unaryOperator = "++"
  val binaryOperators = Set("+", "-", "*", "/")

  def generateHpf(input: String): String = {
    val inputs = input.split(" ").map(_.trim).toVector
    generate(inputs)
  }

  private def generate(inputs: Vector[String], expressions: Vector[String] = Vector.empty): String = {
    if (inputs.isEmpty) s"${expressions.head}"
    else {
      val expressionsSize = expressions.size
      inputs.head match {
        case unaryOp if unaryOp == unaryOperator =>
          val last = expressions.last
          val rest = expressions.take(math.max(0, expressionsSize - 2))
          generate(inputs.tail, rest :+ s"($last$unaryOp)")
        case binaryOp if binaryOperators(binaryOp) =>
          val last = expressions.last
          val previous = expressions(math.max(0, expressionsSize - 2))
          val rest = expressions.take(expressionsSize - 2)
          generate(inputs.tail, rest :+ s"($previous$binaryOp$last)")
        case number =>
          generate(inputs.tail, expressions :+ number)
      }
    }
  }
}
