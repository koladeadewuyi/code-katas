package ontrack


object Question3 {

   def increment(seq: Seq[Int]): Seq[Int] = if (seq.isEmpty) seq else (seq.mkString.toInt + 1).toString.map(_.toString.toInt)

   increment(Nil)
   increment(Seq(0))
   increment(Seq(1, 2, 3))
   increment(Seq(9, 9, 9))
   
}
