package katas

import scala.util.Try

/**
 * Created by koladeadewuyi@gmail.com on 08/12/2016.
 */
object KarateChop {

  def chop(int: Int, arrayOfInt: Array[_ <: Int]): Int = {
    Try {
      chopAndFindRecursively(int, arrayOfInt.asInstanceOf[Array[Int]])
    }.getOrElse(-1)
  }

  private def chopAndFindRecursively(int: Int, arrayOfInt: Array[Int], offset: Int = 0): Int = {
    if (arrayOfInt.nonEmpty) {
      val chopSize = math.ceil(arrayOfInt.length / 2.0).toInt
      val choppedArray = arrayOfInt.splitAt(chopSize)
      val indexOfItem = choppedArray._1.indexOf(int)
      if (indexOfItem == -1)
        chopAndFindRecursively(int, choppedArray._2, offset + chopSize)
      else
        offset + indexOfItem
    }
    else -1
  }
}
