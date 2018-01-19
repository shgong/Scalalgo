def repeatedStringMatch(A: String, B: String): Int = {

  val la = A.length
  val lb = B.length

  for(i<-0 until la if A(i)==B(0)){

    var left = i
    var right = 0
    var repeat = 1
    while(right<lb && A(left)==B(right)){
      left += 1
      right += 1

      if(right == lb) return repeat
      if(left == la) {
        left = 0
        repeat += 1
      }
    }
  }
   -1
}

repeatedStringMatch("abcd","cdabcdab")
