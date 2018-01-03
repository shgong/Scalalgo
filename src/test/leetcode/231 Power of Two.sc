def isPowerOfTwo(n: Int): Boolean = {
  n != 0 && n>0 && n == (n & -n)
}

/*
0        false
1 2 4 8  n == (n & -n)
-2147483648  corner case

property of FF
a    = -2147483648
a-1  = 2147483647
a&-a = a
a+a  = 0

 */