def plusOne(digits: Array[Int]): Array[Int] = {
  var pos = digits.length - 1

  while(pos>=0){
    digits(pos) += 1
    if(digits(pos)<10) return digits
    else {
      digits(pos) -= 10
      pos -= 1
    }
  }
  1 +: digits
}

plusOne(Array(9,9,9)).toList