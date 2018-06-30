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
    else if (s.isEmpty || p.isEmpty) matches
    else {
      prevRegexChar match {
        case MatchAnyChar =>
          matchRecurse(s.tail, p.tail, s.head, p.head)
        case MatchZeroOrMoreTimes =>
          if (s.head == prevChar) matchRecurse(s.tail, p.tail, s.head, p.head)
          else if (p.head != MatchZeroOrMoreTimes) matchRecurse(s, p, s.head, p.head)
          else matchRecurse(s, p.tail, prevChar, p.head)
        case anyChar =>
          if (prevChar == anyChar) matchRecurse(s.tail, p.tail, s.head, p.head)
          else if (p.head == MatchZeroOrMoreTimes) matchRecurse(s, p.tail.tail, prevChar, p.tail.head)
          else false
      }
    }
  }
}
