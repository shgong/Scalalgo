// Cracking the Safe

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