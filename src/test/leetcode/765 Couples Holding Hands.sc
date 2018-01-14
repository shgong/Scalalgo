def minSwapsCouples(row: Array[Int]): Int = {
  val l = row.length
  val pos = Array.fill(l)(0)
  for (i <- 0 until l) pos(row(i)) = i // position map

  var res = 0
  for (i <- 0 until l by 2 if (row(i) ^ row(i + 1)) != 1) {
    val p = pos(row(i) ^ 1) // position of ideal match
    row(p) = row(i + 1)
    pos(row(i + 1)) = p
    res += 1
  }
  res
}


// no need to recursion, replace either are symmetric

// row(i+1) = row(i) ^ 1    no need to go back reset
// pos(row(i+1)) = i + 1    no need to go back reset

minSwapsCouples(Array(0, 2, 1, 3))
minSwapsCouples(Array(1, 4, 0, 5, 8, 7, 6, 3, 2, 9))
minSwapsCouples(Array(5, 4, 2, 6, 3, 1, 0, 7))
