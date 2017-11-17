def reverseVowels(s: String): String = {

  val l = s.length
  var i = 0
  var j = l - 1
  val arr = s.toCharArray
  val vowel = "aeiouAEIOU"

  while (i < j) {
    while (i < j && !vowel.contains(arr(i))) i += 1
    while (i < j && !vowel.contains(arr(j))) j -= 1
    if (i < j) {
      val tmp = arr(i)
      arr(i) = arr(j)
      arr(j) = tmp
      i += 1
      j -= 1
    }
  }

  String.valueOf(arr)
}

reverseVowels("OEsafslavjslkjviosdajvsadlkjcasldkvjasdlkvjasldkvjlks  adjalkfcdaslkvnadslvs aljdlfknasdl lsa nlsvalsv")