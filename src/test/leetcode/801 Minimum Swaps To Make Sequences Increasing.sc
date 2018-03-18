// Minimum Swaps To Make Sequences Increasing

// allowed to swap elements A[i] and B[i]
// minimum number of swaps to make both sequences strictly increasing


// DP
// swap depend on both side structure

def minSwap(A: Array[Int], B: Array[Int]): Int = {
  val l = A.length
  val m = Array.fill(l)(Integer.MAX_VALUE)
  val n = Array.fill(l)(Integer.MAX_VALUE)

  m(0) = 0  // last don't swap
  n(0) = 1  // last swap

  for (i <- 1 until l) {

    // no swap is fine
    if (A(i) > A(i - 1) && B(i) > B(i - 1)) {
      m(i) = m(i) min m(i - 1)
      n(i) = n(i) min (n(i - 1) + 1)
    }

    // swap is fine
    if (A(i) > B(i - 1) && B(i) > A(i - 1)) {
      m(i) = m(i) min n(i - 1)
      n(i) = n(i) min (m(i - 1) + 1)
    }

  }
  m(l - 1) min n(l - 1)
}

var A = Array(1, 3, 5, 4)
var B = Array(1, 2, 3, 7)

minSwap(A, B)

A = Array(0, 3, 5, 8, 9)
B = Array(2, 1, 4, 6, 9)

minSwap(A, B)

A = Array(0, 4, 4, 5, 9)
B = Array(0, 1, 6, 8, 10)

minSwap(A, B)

A = Array(0, 3, 4, 9, 10)
B = Array(2, 3, 7, 5, 6)

minSwap(A, B)