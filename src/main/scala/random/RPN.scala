package random

import scala.annotation.tailrec

object RPN {

  val unaryOperators = Set("++", "--")
  val binaryOperators = Set("+", "-", "*", "/")

  def generateHPF(input: String): String = {
    toHPF(tokenize(input))
  }

  def evaluateRPN(input: String): Int = {
    evalRPN(tokenize(input))
  }

  @tailrec
  private def toHPF(inputs: Vector[String], expressions: Vector[String] = Vector.empty): String = {
    if (inputs.isEmpty) s"${expressions.head}"
    else {
      val expressionsSize = expressions.size
      inputs.head match {
        case unaryOp if unaryOperators(unaryOp) =>
          val last = expressions.last
          val rest = expressions.take(math.max(0, expressionsSize - 2))
          val expression = s"($last$unaryOp)"
          toHPF(inputs.tail, rest :+ expression)
        case binaryOp if binaryOperators(binaryOp) =>
          val last = expressions.last
          val previous = expressions(math.max(0, expressionsSize - 2))
          val rest = expressions.take(expressionsSize - 2)
          val expression = s"($previous$binaryOp$last)"
          toHPF(inputs.tail, rest :+ expression)
        case number =>
          toHPF(inputs.tail, expressions :+ number)
      }
    }
  }

  @tailrec
  private def evalRPN(inputs: Vector[String], expressions: Vector[Int] = Vector.empty): Int = {
    if (inputs.isEmpty) expressions.sum
    else {
      val expressionSize = expressions.size
      inputs.head match {
        case unaryOp if unaryOperators(unaryOp) =>
          val last = expressions.last
          val rest = expressions.take(math.max(0, expressionSize - 2))
          val expression = evalUnaryOp(last, unaryOp)
          evalRPN(inputs.tail, rest :+ expression)
        case binaryOp if binaryOperators(binaryOp) =>
          val last = expressions.last
          val previous = expressions(math.max(0, expressionSize - 2))
          val rest = expressions.take(math.max(0, expressionSize - 2))
          val expression = evalBinaryOp(previous, binaryOp, last)
          evalRPN(inputs.tail, rest :+ expression)
        case number =>
          evalRPN(inputs.tail, expressions :+ number.toInt)
      }
    }
  }

  private def evalUnaryOp(left: Int, op: String): Int = op match {
    case "++" => left + 1
    case "--" => left - 1
    case anyOp => throw new IllegalArgumentException(s"Unsupported unary operation $anyOp")
  }

  private def evalBinaryOp(left: Int, op: String, right: Int): Int = op match {
    case "+" => left + right
    case "-" => left - right
    case "*" => left * right
    case "/" => left / right
    case anyOp => throw new IllegalArgumentException(s"Unsupported binary operation $anyOp")
  }

  private def tokenize(input: String): Vector[String] = {
    input.split(" ").map(_.trim).toVector
  }
}
