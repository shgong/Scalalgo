def lengthOfLongestSubstring(s: String): Int = {
  val l = s.length
  var left = 0
  var right = 0
  var maxlen = 0

  while (right < l) {
    while (s.substring(left, right).contains(s(right))) left += 1
    maxlen = maxlen max (right - left + 1)
    right += 1
  }

  maxlen
}

lengthOfLongestSubstring("pwwkew")
lengthOfLongestSubstring("")
lengthOfLongestSubstring("a")
lengthOfLongestSubstring("aa")