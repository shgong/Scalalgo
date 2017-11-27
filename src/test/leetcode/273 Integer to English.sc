val belowTen = List("", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine")
val belowTwenty = List("Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen")
val belowHundred = List("", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety")


def numberToWords(num:Int) =
  if (num == 0) "Zero" else helper(num)


def helper(num:Int):String = {
  if (num < 10) belowTen(num)
  else if (num < 20) belowTwenty(num - 10)
  else if (num < 100) belowHundred(num / 10) + " " + helper(num % 10)
  else if (num < 1000) helper(num / 100) + " Hundred " + helper(num % 100)
  else if (num < 1000000) helper(num / 1000) + " Thousand " + helper(num % 1000)
  else if (num < 1000000000) helper(num / 1000000) + " Million " + helper(num % 1000000)
  else helper(num / 1000000000) + " Billion " + helper(num % 1000000000)
}.trim
numberToWords(1231232141)