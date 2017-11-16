def checkPerfectNumber(num: Int): Boolean = {
  if (num == 1) false
  else {
    var sum = 1
    for (i <- 2 to Math.sqrt(num).toInt
         if num % i == 0) {
      sum += i
      if (i != num / i) sum += num / i
    }
    sum == num
  }
}

checkPerfectNumber(28)