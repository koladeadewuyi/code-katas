package hackerRank

import scala.annotation.tailrec

object Problem1 {

  def rotLeft(array: Seq[Int], numRotations: Int): Seq[Int] = {
    require(array.nonEmpty && array.size <= math.pow(10, 5))
    require(numRotations >= 1 && numRotations <= array.size)
    rotateLeft(array.toVector, numRotations) // converting array to Vector to improve performance
  }

  @tailrec
  private def rotateLeft(rotatedArray: Vector[Int], numRotations: Int): Seq[Int] = {
    if (numRotations <= 0) rotatedArray
    else {
      rotateLeft(rotatedArray.tail :+ rotatedArray.head, numRotations - 1) // Vector.tail (eC) performs better than Seq.tail (O(n))
    }
  }

}
