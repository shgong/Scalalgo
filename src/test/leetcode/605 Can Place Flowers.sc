def canPlaceFlowers(flowerbed: Array[Int], n: Int): Boolean = {
  var last = 0
  var count = 1  // sp for left
  var total = 0
  for(i<-flowerbed){
    if(i==0) {
      if(last==0) count+=1
      else {last = 0; count=1}
    } else {
      total += (count-1) / 2
      count = 0
    }
  }
  total += count / 2 // sp for right
  total >= n
}

/*
0 -> 0
00 -> 0
000 -> 1
0000 -> 1
00000 -> 2
 */

canPlaceFlowers(Array(1,0,0,0,1),1)
canPlaceFlowers(Array(0,0,1,0,1),1)