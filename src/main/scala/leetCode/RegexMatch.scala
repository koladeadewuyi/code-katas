package leetCode

import scala.annotation.tailrec

object RegexMatch {

  val MatchAnyChar = '.'
  val MatchZeroOrMoreTimes = '*'

  def isMatch(s: String, p: String): Boolean = {
    matchRecurse(s.tail, p.tail, s.head, p.head)
  }

  @tailrec
  private def matchRecurse(s: String, p: String, prevChar: Char, prevRegexChar: Char, matches: Boolean = true): Boolean = {
    if (s.nonEmpty && p.isEmpty) false
    else if (s.isEmpty && p.isEmpty) matches
    else if (s.isEmpty && p.nonEmpty) false
    else {
      prevRegexChar match {
        case MatchAnyChar =>
          matchRecurse(s.tail, p.tail, s.head, p.head)
        case MatchZeroOrMoreTimes =>
          if (s.head == prevChar) matchRecurse(s.tail, p, s.head, prevRegexChar)
          else if (s.head != prevChar) matchRecurse(s.tail, p.tail, s.head, p.head)
          else false
        case anyChar =>
          if (prevChar == anyChar) matchRecurse(s.tail, p.tail, s.head, p.head)
          else false
      }
    }
  }
}
