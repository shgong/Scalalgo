def pourWater(heights: Array[Int], V: Int, K: Int): Array[Int] = {
  var v = V
  val l = heights.length
  while (v > 0) {

    var cur = K
    while (cur>0 && heights(cur - 1) <= heights(cur)) cur -= 1
    while (cur<K && heights(cur + 1) <= heights(cur)) cur += 1

    if(heights(cur)>= heights(K)) {
      cur = K
      while (cur<l-1 && heights(cur + 1) <= heights(cur)) cur += 1
      while (cur>K && heights(cur - 1) <= heights(cur)) cur -= 1

      if(heights(cur)>= heights(K)) cur = K
    }

    heights(cur)+=1
    println(heights.toList)
    v -= 1

  }
  heights

}

pourWater(Array(1,2,3,4,3,2,1,2,3,4,3,2,1), 20,2)

/*
[1,2,3,4,3,2,1,2,3,4,3,2,1]
20
2
 */