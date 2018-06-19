package random

object Combination {
  def combination(n: Int, r: Int): Int = {
    compute(n, n - r, r)
  }

  private def compute(n: Int, c: Int, r: Int, nFac: Int = 1, cFac: Int = 1, rFac: Int = 1): Int = {
    (n, c, r) match {
      case (0, 0, 0) => nFac / (cFac * rFac)
      case (0, 0, r) => compute(0, 0, r - 1, nFac, cFac, r * rFac)
      case (0, c, 0) => compute(0, c - 1, 0, c * nFac, cFac, rFac)
      case (n, 0, 0) => compute(n - 1, 0, 0, n * nFac, cFac, rFac)
      case (n, 0, r) => compute(n - 1, 0, r - 1, n * nFac, cFac, r * rFac)
      case (n, c, 0) => compute(n - 1, c - 1, 0, n * nFac, c * cFac, rFac)
      case (0, c, r) => compute(0, c - 1, r - 1, nFac, c * cFac, r * rFac)
      case (n, c, r) => compute(n - 1, c - 1, r - 1, n * nFac, c * cFac, r * rFac)
    }
  }
}
