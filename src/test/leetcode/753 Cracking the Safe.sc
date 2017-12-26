// Cracking the Safe
// n digit, k available

// use formula of Inverse Burrows-Wheeler Transform
def crackSafe(n: Int, k: Int): String = {

  if(k==1) return "0"*n
  val a = Array.fill(k * n)(0)
  val res = collection.mutable.ArrayBuffer[String]()

  def brute(t: Int, p: Int): Unit = {
    if (t > n) {
      if (n % p == 0) res.append(a.slice(1, p + 1).mkString(""))
    } else {
      a(t) = a(t - p)
      brute(t + 1, p)
      for (j <- a(t - p) + 1 until k) {
        a(t) = j
        brute(t + 1, t)
      }
    }
  }

  brute(1, 1)
  val out = res.mkString("")
  out ++ out.take(n-1)
}

// 012
// 0121021
crackSafe(1, 2)
crackSafe(3, 2)
crackSafe(2, 2)
crackSafe(2,2)

/* Euler Circuit
 find a euler path on graph with k^n-1 nodes and k edges
 k=4 n=3

 00 01 02 ... 32 33
 dfs that keep track of edges

 start from all zero, every time try add a digit
*/

def crack(n:Int, k:Int) = {
  val seen = collection.mutable.HashSet[String]()
  val result = new StringBuilder()

  def dfs(node:String): Unit = {
    for(x<-0 until k) {
      val c = ('0'+x).toChar
      val nei = node + c
      if(!seen.contains(nei)) {
        seen.add(nei)
        dfs(nei.substring(1))
        result.append(c)
      }
    }

  }

  dfs("0"*(n-1))
  result.mkString("") + "0"*(n-1)
}

crack(3,3)