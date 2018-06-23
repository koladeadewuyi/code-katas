package projectEuler

import scala.annotation.tailrec

object Problem10 {

  private val FirstPrimeNumber = 2

  @tailrec
  def sumOfPrimesBelow(limit: Int, number: Int = FirstPrimeNumber, sumOfPrimes: Long = 0, primes: Seq[Int] = Nil): Long = {
    if (primes.nonEmpty && number >= limit) sumOfPrimes
    else {
      if (isNotPrime(number, primes))
        sumOfPrimesBelow(limit, number + 1, sumOfPrimes, primes)
      else
        sumOfPrimesBelow(limit, number + 1, sumOfPrimes + number, number +: primes)
    }
  }

  private def isNotPrime(number: Int, primes: Seq[Int]): Boolean = {
    primes.exists(prime => number % prime == 0)
  }

}
