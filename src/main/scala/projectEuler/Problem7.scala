package projectEuler

import scala.annotation.tailrec
import scala.collection.SortedSet

object Problem7 {

  def nthPrimeNumber(N: Int): Int = {
    compute(N - 1, 2, SortedSet.empty[Int])
  }

  @tailrec
  private def compute(N: Int, number: Int, primes: SortedSet[Int]): Int = {
    if (N < 0) primes.last
    else {
      val isNotPrime = primes.exists(prime => number % prime == 0)
      if (isNotPrime) compute(N, number + 1, primes)
      else compute(N - 1, number + 1, primes + number)
    }
  }
}

