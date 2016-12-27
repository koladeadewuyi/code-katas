package projectEuler

/**
 * Created by koladeadewuyi@gmail.com on 26/12/2016.
 */
object Problem3 {

  def largestPrimeFactor(number: Long): Long = {
    val start = System.nanoTime()
    val result = compute(number, number)
    println((System.nanoTime() - start) / 1.0e5)
    result
  }

  private def compute(number: Long, factor: Long = 1l, divisor: Int = 1): Long = {
    if (divisor > number / 2) number
    else if (factor != number && (factor * divisor <= number) && isPrime(factor)) factor
    else {
      val isFactor = number % (divisor + 1) == 0
      val result = if (isFactor) number / (divisor + 1) else factor
      compute(number, result, divisor + 1)
    }
  }

  def isPrime(factor: Long): Boolean = {
    !Iterator.iterate(2l)(_ + 1).takeWhile(_ <= factor.toLong / 2).exists(x => (factor % x) == 0l)
  }
}
