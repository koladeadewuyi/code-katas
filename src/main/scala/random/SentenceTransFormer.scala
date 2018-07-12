package random

import scala.annotation.tailrec

object SentenceTransFormer {

  @tailrec
  def transFormWords(words: Seq[String], results: Seq[String] = Seq.empty[String]): Seq[String] = {
    words.lastOption match {
      case Some(word) =>
        val updatedResult = if (results.isEmpty) word.map(_.toString)
        else word.flatMap { character =>
          results.map(resultChar => character + resultChar)
        }
        transFormWords(words.take(words.size - 1), updatedResult)
      case _ => results
    }
  }
}
