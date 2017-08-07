package ch2.gcj

/*
given 0,1 matrix
exchange adjacent two rows
make all elements above diagonal zero

find how many exchanges is needed at least

N=4
1110
1100
1100
1000

output: 4
 */

object CrazyRows {

  // only care last 1 in each row
  // convert, then find first <=0 row, swap with first, thus loop
  def solve(m: Array[Array[Int]]) = {
    val a = m.map(_.zipWithIndex.filter(_._1 == 1).lastOption.map(_._2).getOrElse(-1))
    a.indices.foreach { i =>
      val target = a.zipWithIndex.drop(i).find(_._1 <= i).map(_._2).get
      for (sw <- target until i by -1) {
        println(s"swap $sw ${sw - 1}")
        val tmp = a(sw); a(sw) = a(sw - 1); a(sw - 1) = tmp
      }
    }
  }
}
