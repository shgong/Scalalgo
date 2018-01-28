// 771. Jewels and Stones

def numJewelsInStones(J: String, S: String): Int = {
  S.count(J.contains(_))
}

numJewelsInStones("aA","aAAbbbb")