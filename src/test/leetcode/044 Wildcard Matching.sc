// Wildcard matching

def isMatch(s: String, p: String): Boolean = {

  var (i,j,mat,idx) = (0,0,0,-1)
  while(i<s.length){

    if(j<p.length && (p(j)=='?' || s(i)==p(j))){
      // advance both pointer
      i += 1
      j += 1
    } else if(j<p.length && p(j)=='*'){
      // advance j when *, match nothing for now
      idx = j
      mat = i
      j += 1
    } else if(idx != -1) {
      // if have previous *, match one more
      j = idx + 1
      mat += 1
      i = mat
    } else return false
  }

  // only * left if s empty
  while(j<p.length && p(j)=='*') j+=1
  j == p.length
}


isMatch("hello", "h*o")