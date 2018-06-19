package hackerRank

object Problem13 {

  def lonelyInteger(array: Vector[Int]): Int = {
    array.groupBy(x => x).filter(_._2.size < 2).keys.headOption.getOrElse(0)
  }

}
