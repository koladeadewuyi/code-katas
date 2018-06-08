package projectEuler

object Problem9 {

  def specialPythagoreanTriplet(sum: Int, m: Int): (Int, Int, Int) = {
    if (m <= 1) (0, 0, 0)
    else {
      val n = ((sum / 2 - sqr(m)) / m).toInt
      val a = (sqr(m) - sqr(n)).toInt
      val b = 2 * m * n
      val c = (sqr(m) + sqr(n)).toInt

      if (isPythagoreanTriplet(a, b, c) && (a + b + c) == sum)
        (a, b, c)
      else
        specialPythagoreanTriplet(sum, m - 1)
    }
  }

  private def isPythagoreanTriplet(a: Int, b: Int, c: Int): Boolean = {
    a > 0 && b > 0 && c > 0 && (sqr(a) + sqr(b)) == sqr(c)
  }

  private def sqr(x: Double) = Math.pow(x, 2)
}
