package ontrack

object Question2 {

   val f1: (Int, Int) => Int = (a, b) => a + b
   val f2: Int => String = _.toString
   val f3: (Int, Int) => String = (a, b) => f2(f1(a, b))

}
