/*
Given a positive integer n and you can do operations as follow:

If n is even, replace n with n/2.
If n is odd, you can replace n with either n + 1 or n - 1.
What is the minimum number of replacements needed for n to become 1?


1001
9 8 4 2 1
9 10 5 4 2 1
*/


def integerReplacement(n: Int): Int = {
  var ops = 0
  var x:Long = n  // overflow

  while (x != 1) {
    if ((x & 1) == 0) x >>= 1
    else if (x != 3 && (x & 2) == 2) x += 1  // special case 3, otherwise +1 always better
    else x -= 1
    ops += 1
  }

  ops
}

integerReplacement(3)
integerReplacement(9)
integerReplacement(65535)
integerReplacement(2147483647)
