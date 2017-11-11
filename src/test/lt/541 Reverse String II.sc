
// Given a string and an integer k,
// you need to reverse the first k characters for every 2k characters
// counting from the start of the string.
//
// If there are less than k characters left, reverse all of them.
// If there are less than 2k but greater than or equal to k characters,
//    then reverse the first k characters and left the other as original.


def reverseStr(s: String, k: Int): String = {
  val l = s.length
  val n = l / k
  val res = l % k
  var flip = false
  var result = ""

  (0 until n).map{ i=>
    val seg = s.substring(i*k, (i+1)*k)
    flip = !flip
    if(flip) seg.reverse else seg
  }.mkString("") + (if(res>0){
    val seg = s.substring(l-res, l)
    if(!flip) seg.reverse else seg
  } else "")

}

def charArrayBased(s: String, k: Int): String = {
  var ns = s.toCharArray
  for(i<- 0 until ns.length by 2*k){
    var j = i
    var l = Math.min(j + k - 1, ns.length - 1)
    while(j < l){
      var temp = ns(j)
      ns(j) = ns(l)
      ns(l) = temp
      j += 1
      l -= 1
    }
  }
  new String(ns)
}


reverseStr("appleooogoogleoofacebo", 4)
