package katas

/**
 * Created by koladeadewuyi@gmail.com on 08/12/2016.
 */
object SummablePairs {

  def find(sum: Int, arrayOfInt: Array[_ <: Int]): List[(Int, Int)] = {
    if (arrayOfInt.size == 0 || arrayOfInt.size < 2) List.empty
    else findSummablePairs(sum, arrayOfInt)
  }

  private def findSummablePairs(sum: Int, arrayOfInt: Array[_ <: Int], compliments: Set[Int] = Set.empty, pairs: List[(Int, Int)] = List.empty): List[(Int, Int)] = {
    if (arrayOfInt.size == 0) pairs
    else {
      val number = arrayOfInt.head
      val compliment = sum - number
      if (compliments.contains(number)) {
        findSummablePairs(sum, arrayOfInt.tail, compliments + compliment, pairs ++ List((compliment, number)))
      } else {
        findSummablePairs(sum, arrayOfInt.tail, compliments + compliment, pairs)
      }
    }
  }

}
