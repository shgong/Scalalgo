//  find the minimum number of moves required to make all array elements equal, where a move is incrementing a selected element by 1 or decrementing a selected element by 1

def minMoves2(nums: Array[Int]): Int = {
  val counts = nums.groupBy(identity).mapValues(_.length).toArray.sorted
  val len = counts.length

  // note: long int
  val inc = Array.fill(len)(0L)
  val dec = Array.fill(len)(0L)

  var toInc = counts(0)._2
  for (i <- 1 until len) {
    inc(i) = inc(i - 1) + toInc.toLong * (counts(i)._1 - counts(i - 1)._1)
    toInc += counts(i)._2
  }

  var toDec = counts(len - 1)._2
  for (i <- len - 2 to 0 by -1) {
    dec(i) = dec(i + 1) + toDec.toLong * (counts(i + 1)._1 - counts(i)._1)
    toDec += counts(i)._2
  }

  inc.zip(dec).map{case (a,b) =>a + b}.min.toInt
}

minMoves2(Array(203125577,-349566234,230332704,48321315,66379082,386516853,50986744,-250908656,-425653504,-212123143))