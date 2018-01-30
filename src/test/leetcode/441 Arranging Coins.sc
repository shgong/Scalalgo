def arrangeCoins(n: Int): Int = {
  var k = 1
  var left = n
  while(left>=k){
    left -= k
    k += 1
  }
  k-1
}