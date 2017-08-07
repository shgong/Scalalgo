package ch3.dynamic

object Blocks {

  // N blocks, paint with R B G Y
  // how many plan have even R and even G

  def solve(N: Int): Int = {
    /* math problem
       ai  RG even
       bi  one of RG even
       ci  RG odd

       ai+1 = 2ai + bi
       bi+1 = 2ai + 2bi + 2ci
       ci+1 = bi + 2ci

       ai   |2 1 0| i |1|
       bi = |2 2 2|   |0|
       ci   |0 1 2|   |0|
    */

    var (a,b,c) = (1,0,0)
    for (i <- 1 to N) {
      a = 2 * a + b
      c = 2 * c + b
      b = a + c
    }
    a
  }

  def main(args: Array[String]): Unit = {

    println(solve(1)) //2
    println(solve(2)) //6   RR BB BY YB YY GG
  }
}
