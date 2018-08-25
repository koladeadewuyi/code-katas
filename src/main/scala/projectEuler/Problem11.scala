package projectEuler

import scala.annotation.tailrec
import scala.language.postfixOps

object Problem11 {

  def largestProductInGrid(matrix: Vector[Vector[Short]], numOfAdjacentNumbers: Int): Int = {
    findLargestProductRecurse(matrix, numOfAdjacentNumbers)
  }

  @tailrec
  private def findLargestProductRecurse(matrix: Vector[Vector[Short]], numOfAdjacentNumbers: Int, rowIndex: Int = 0, colIndex: Int = 0, prevProduct: Int = 0): Int = {
    val matrixHeight = matrix.size
    val matrixWidth = matrix.headOption.getOrElse(Vector.empty).size
    if (rowIndex >= matrixHeight && colIndex >= matrixWidth) prevProduct
    else {
      val horizontalProduct: Vector[Short] = matrix(math.min(rowIndex, matrixHeight - 1)).sliding(numOfAdjacentNumbers).toVector.map(x => x.product)
      val verticalProduct: Vector[Short] = Vector((rowIndex to numOfAdjacentNumbers) collect { case r if r < matrixHeight => matrix(r)(colIndex) } product)
      val descendingDiagonalProduct = Nil
      val ascendingDiagonalProduct = Nil
      val currentProduct = (horizontalProduct ++ verticalProduct ++ descendingDiagonalProduct ++ ascendingDiagonalProduct).max
      findLargestProductRecurse(matrix, numOfAdjacentNumbers, rowIndex + 1, colIndex + 1, math.max(prevProduct, currentProduct))
    }
  }

}
