package hackerRank

import utils.IsTrue

object Problem3 {

  def checkMagazine(magazine: Array[String], note: Array[String]): IsTrue.Value = {
    val magazineWordCounts = magazine.groupBy(identity).mapValues(_.length)
    val noteWordCounts = note.groupBy(identity).mapValues(_.length)
    if (noteWordCounts.forall { case (word, occurrence) => magazineWordCounts.getOrElse(word, 0) >= occurrence })
      IsTrue.Yes
    else
      IsTrue.No
  }

}
