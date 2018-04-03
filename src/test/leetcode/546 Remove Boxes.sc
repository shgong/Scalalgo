/*
Given several boxes with different colors

You may experience several rounds to remove boxes
until there is no box left

Each time you can choose some continuous boxes with the same color
 (composed of k boxes, k >= 1), remove them and get k*k points.

Find the maximum points you can get.

[1, 3, 2, 2, 2, 3, 4, 3, 1]
----> [1, 3, 3, 4, 3, 1] (3*3=9 points)
----> [1, 3, 3, 3, 1] (1*1=1 points)
----> [1, 1] (3*3=9 points)
----> [] (2*2=4 points)
 */

def removeBoxes(boxes: Array[Int]): Int = {

  val l = boxes.length
  val memo = Array.fill(l)(Array.fill(l)(Array.fill(l)(-1)))

  // dp i j k
  //    max value from i to j, if we have k box with color i to the left

  def find(i: Int, j: Int, k: Int): Int = {
    if (i > j) return 0

    if (memo(i)(j)(k) == -1) {
      var m = i
      while (m < j && boxes(m + 1) == boxes(i)) m += 1

      val i0 = m
      val k0 = k + m - i

      // baseline, remove current color
      var ans = find(i0 + 1, j, 0) + (k0 + 1) * (k0 + 1)

      // see if possible to connect with left color after remove some blocks
      for (m <- i0 + 1 to j if boxes(i) == boxes(m))
        ans = ans max (find(i0 + 1, m - 1, 0) + find(m, j, k0 + 1))

      memo(i)(j)(k) = ans
    }
    memo(i)(j)(k)
  }

  find(0, l - 1, 0)
}
