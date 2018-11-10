package hackerRank

object Problem10 {

  def countSwaps(array: Vector[Int]): Int = {
    sort(array)
  }

  private def sort(array: Vector[Int], bubbleSorted: Vector[Int] = Vector.empty, swaps: Int = 0): Int = {
    if (array.isEmpty) swaps
    else bubble(array, Vector.empty, bubbleSorted, swaps)
  }

  private def bubble(array: Vector[Int], sorted: Vector[Int] = Vector.empty, bubbleSorted: Vector[Int] = Vector.empty, swaps: Int = 0): Int = {
    if (array.isEmpty) swaps
    else {
      array match {
        case h1 +: (h2 +: t) =>
          if (h1 > h2) bubble(h1 +: t, h2 +:sorted, bubbleSorted, swaps + 1)
          else bubble(h2 +: t, h1 +: sorted, bubbleSorted, swaps)
        case h1 +: IndexedSeq() =>
          sort(sorted, h1 +: bubbleSorted, swaps)
      }
    }
  }

}
