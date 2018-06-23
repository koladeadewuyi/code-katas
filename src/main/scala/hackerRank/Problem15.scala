package hackerRank

object Problem15 {

  def countInversions(array: Vector[Int]): Long = {
    val (sorted, inversions) = mergeSort(array)
    inversions
  }

  private def mergeSort(array: Vector[Int], inversions: Long = 0): (Vector[Int], Long) = {
    if (array.size <= 1) (array, inversions)
    else {
      val middle = math.ceil(array.size / 2).toInt
      val (left, right) = array.splitAt(middle)
      if (left.nonEmpty && right.nonEmpty && left.last > right.head) {
        val (rightSort, rightInversion) = mergeSort(right, inversions + 1)
        val (leftSort, leftInversion) = mergeSort(left)
        (rightSort ++ leftSort, rightInversion + leftInversion)
      } else {
        val (leftSort, leftInversion) = mergeSort(left, inversions)
        val (rightSort, rightInversion) = mergeSort(right)
        if (leftSort.last > rightSort.head) {
          val (leftSort1, leftInversion1) = mergeSort(leftSort :+ rightSort.head, leftInversion + 1)
          val (rightSort1, rightInversion1) = mergeSort(rightSort.tail, rightInversion)
          (leftSort1 ++ rightSort1, leftInversion1 + rightInversion1)
        } else (leftSort ++ rightSort, leftInversion + rightInversion)
      }
    }
  }

}
