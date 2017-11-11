// License Key Formatting

object Solution {
  def licenseKeyFormatting(S: String, K: Int): String = {
    var s = S.toUpperCase.filter(_!='-')

    (0 to (s.length-1) / K).map{_=>
      val part = s.takeRight(K)
      s = s.dropRight(K)
      part
    }.reverse.mkString("-")
  }
}


val S = "2-4A0r7-4k"
val K = 3