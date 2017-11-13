def isPalindrome(s: String): Boolean = {
  val alphanumeric = s.filter(_.isLetterOrDigit).toLowerCase
  alphanumeric == alphanumeric.reverse
}