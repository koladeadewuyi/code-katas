package leetCode

object MedianOfSortedArrays {

  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
    val totalLength = nums1.length + nums2.length
    val joinedNumbers = (nums1 ++ nums2).sorted
    val middle = totalLength / 2

    if (totalLength % 2 == 0) {
      (joinedNumbers(middle - 1) + joinedNumbers(middle)).toDouble / 2
    } else {
      joinedNumbers(middle)
    }
  }

}