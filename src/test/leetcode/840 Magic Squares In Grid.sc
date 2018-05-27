/*
840. Magic Squares In Grid

A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that
each row, column, and both diagonals all have the same sum.

Given an N x N grid of integers,
how many 3 x 3 "magic square" subgrids are there?
(Each subgrid is contiguous).
 */

def numMagicSquaresInside(grid: Array[Array[Int]]): Int = {
  val h = grid.length
  val w = grid(0).length

  var count = 0
  for(i<-0 until h-2; j<-0 until w-2){
    val a1 = grid(i)(j)
    val a2 = grid(i)(j+1)
    val a3 = grid(i)(j+2)

    val b1 = grid(i+1)(j)
    val b2 = grid(i+1)(j+1)
    val b3 = grid(i+1)(j+2)

    val c1 = grid(i+2)(j)
    val c2 = grid(i+2)(j+1)
    val c3 = grid(i+2)(j+2)


    if (List(a1,a2,a3,b1,b2,b3,c1,c2,c3).sorted == List(1,2,3,4,5,6,7,8,9) &&
    a1+a2+a3==15 && b1+b2+b3==15 && c1+c2+c3==15 && a1+b1+c1==15 && a2+b2+c2==15 &&
    a3+b3+c3==15 && a1 + b2 + c3 == 15 && a3+b2+c1==15)  count += 1
  }

  count

}

numMagicSquaresInside(
  Array(
    Array(4,3,8,4),
    Array(9,5,1,9),
    Array(2,7,6,2)
  )
)