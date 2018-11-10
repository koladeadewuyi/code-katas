package random

import testUtils.TestFixture

import scala.collection.breakOut
import scala.collection.immutable.TreeSet

class CollectionExerciseSpec extends TestFixture {

  val list = List("now", "is", "the", "time")
  val names = Map(
    "Martin" -> "Odersky",
    "Joe" -> "Armstrong",
    "Simon" -> "Peyton Jones"
  )

  it("should reverse given collection") {
    val result = list.reverse
    result should contain theSameElementsInOrderAs List("time", "the", "is", "now")
  }

  it("should convert all items in collection to UPPERCASE") {
    val result = list.map(_.toUpperCase)
    result should contain theSameElementsInOrderAs List("NOW", "IS", "THE", "TIME")
  }

  it("should return the first element") {
    val result = list.head
    result shouldBe "now"
  }

  it("should return the tail, all but the first element") {
    val result = list.tail
    result should contain theSameElementsInOrderAs List("is", "the", "time")
  }

  it("should return the last element. (Warning: O(n) time)") {
    val result = list.last
    result shouldBe "time"
  }

  it("should sort the elements by length") {
    val result = list.sortBy(_.length)
    result should contain theSameElementsInOrderAs List("is", "now", "the", "time")
  }

  it(
    """should partition the collection elements into two collections,
      where one has the words that start with "t" and the other
      collection has the rest of the words."""
  ) {
    val result = list.partition(_.startsWith("t"))
    result shouldBe Tuple2(List("the", "time"), List("now", "is"))
  }

  it("should zip the collection elements with their lengths") {
    val result = list.zip(list.map(_.length))
    result should contain theSameElementsInOrderAs List(("now", 3), ("is", 2), ("the", 3), ("time", 4))
  }

  it("should make a string from the list that matches the expected string shown") {
    val result = list.mkString("[", "-", "]")
    result shouldBe "[now-is-the-time]"
  }

  it("""should Map the "names" above to a 3-element list where each name is "first last""""
  ) {
    val result: List[String] = names.map {
      case (firstName, lastName) => s"$firstName $lastName"
    }(breakOut)
    result should contain theSameElementsInOrderAs List("Martin Odersky", "Joe Armstrong", "Simon Peyton Jones")
  }


  val stuff = Map(1 -> "a", 2 -> "b", 1 -> "c", 3 -> "d", 2 -> "e")
  val expected11: Map[Int, String] = stuff

  it("Use Map API call to group by the numbers used as keys") {
    expected11.groupBy { case (k, _) => k } shouldBe Map(
      1 -> Map(1 -> "a", 1 -> "c"),
      2 -> Map(2 -> "b", 2 -> "e"),
      3 -> Map(3 -> "d")
    )
  }

  it("should return right result when we retrieve map elements") {
    val expected12 = Option(expected11.filter { case (k, _) => k == 1 })
    expected12 shouldBe Some(Map(1 -> "a", 1 -> "c"))

    val expected13 = expected11.get(4)
    expected13 shouldBe None

    val expected14 = expected11.getOrElse(4, Map(4 -> "unknown"))
    expected14 shouldBe Map(4 -> "unknown")
  }

  private object CharOrdering extends Ordering[Char] {
    override def compare(x: Char, y: Char): Int = x - y
  }

  private def uniques(arg: String): List[Char] = uniques(List(arg))

  private def uniques(arg: String, args: String*): List[Char] = uniques(arg +: args)

  private def uniques(args: Seq[String]): List[Char] = {
    args.flatten
      .foldLeft(TreeSet.empty[Char](CharOrdering))((treeSet, char) => treeSet + char)
      .toList
  }

  val expected15 = List('N', 'T', 'e', 'h', 'i', 'm', 'o', 's', 't', 'w')

  it("should return uniques when given allowed inputs") {
    uniques("Now", "is", "the", "Time") should contain theSameElementsInOrderAs expected15
    uniques("Now" :: "is" :: "the" :: "Time" :: Nil) should contain theSameElementsInOrderAs expected15
    uniques(List("Now", "is", "the", "Time")) should contain theSameElementsInOrderAs expected15
    uniques("Now") should contain theSameElementsInOrderAs List('N', 'o', 'w')
  }

}
