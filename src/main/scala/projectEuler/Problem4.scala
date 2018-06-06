package projectEuler

object Problem4 {

  def largestPalindromeProduct(numberOfDigits: Int): Int = {
    val lowerBound: Int = ("1" + ("0" * (numberOfDigits - 1))).toInt
    val upperBound: Int = (scala.math.pow(10, numberOfDigits) - 1).toInt

    val palindromes = for {
      i <- lowerBound to upperBound
      j <- (lowerBound + 1) until upperBound
      product = i * j
      if isPalindrome(product.toString)
    } yield product

    palindromes.max
  }

  private def isPalindrome(word: String): Boolean = {
    val numberOfChars = scala.math.floor(word.length / 2).toInt
    val left = word.take(numberOfChars)
    val right = word.takeRight(numberOfChars)
    left == right.reverse
  }
}
