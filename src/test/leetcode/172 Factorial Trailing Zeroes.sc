// 2,5,
// count 5 factor is enough

def trailingZeroes(n: Int): Int = {
  var res = 0
  var factor = 5

  // avoid overflow
  while(factor < factor*5 ){
    res += n / factor
    factor *= 5
  }

  res
}