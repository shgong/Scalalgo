def selfDividingNumbers(left: Int, right: Int): List[Int] = {

  (left to right).filter { i =>
    if (i.toString.contains('0')) false
    else {
      val digits = i.toString.toCharArray.map(_ - '0').toSet
      digits.forall(j => i % j == 0)
    }
  }.toList

}

selfDividingNumbers(1, 22)