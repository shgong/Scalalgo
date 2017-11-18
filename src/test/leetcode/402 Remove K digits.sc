
// make new number smallest

def removeKdigits(num: String, k: Int): String = {
  // clean up
  // remove zeros, avoid empty strings
  var res = rec(num,k)
  while(res.nonEmpty && res(0)=='0') res = res.drop(1)
  if(res=="") "0" else res
}

def rec(num: String, k: Int): String = {
  if(k==0) return num
  if(num.length == k) return ""

  // first minimize first number
  var min = 255
  var pos = 0
  var i = 0

  while(i<=k){
    if(num(i)=='0' || num(i)<min) {
      min = num(i)
      pos = i
      if(num(i)=='0') i = k
    }
    i+=1
  }

  // if smallest is pos
  num.slice(pos, pos+1) +       // keep that digit
    rec(num.drop(pos+1), k-pos) // rest rec

  // can change to tailrec
}

removeKdigits("112", 1)
removeKdigits("10", 2)
removeKdigits("1432219",3)