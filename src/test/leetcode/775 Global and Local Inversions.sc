// 775. Global and Local Inversions

// read carefully
// adjacent->local, any pair->global

def isIdealPermutation(A: Array[Int]): Boolean = {
  val l = A.length
  if(l==0) return false

  var lastmax = Integer.MIN_VALUE
  var last = Integer.MIN_VALUE
  var max =Integer.MIN_VALUE
  var dec = false

  for(i<-A){
    if(i<lastmax) return false
    else if(i<last) {
      if(dec) return false
      dec = true
      last = i
    } else if (i<max) return false
    else if(i>=max){
      dec = false
      lastmax = max
      max = i
      last = i
    }
  }
  true
}


isIdealPermutation(Array(1,0,2))
isIdealPermutation(Array(1,2,0))
isIdealPermutation(Array(1,1,2,3))
isIdealPermutation(Array(1,0,0,2,3))
isIdealPermutation(Array(1,1,0,2,3))
isIdealPermutation(Array(2,1,0))