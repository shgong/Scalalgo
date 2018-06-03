/*
846. Hand of Straights

Alice has a hand of cards,
given as an array of integers.

Now she wants to rearrange the cards into groups
so that each group is size W,
consists of W consecutive cards.

Return true if and only if she can.
 */

def isNStraightHand(hand: Array[Int], W: Int): Boolean = {
  val l = hand.length
  if(l % W != 0) return false

  val count = collection.mutable.LinkedHashMap[Int,Int](hand.groupBy(identity).mapValues(_.length).toSeq.sorted:_*)
  while(count.nonEmpty){
    val (num, c) = count.head
    count.remove(num)

    for(i<-num+1 until num+W){
      if(count.contains(i) && count(i)>=c){
        count(i) -= c
        if(count(i)==0) count.remove(i)
      } else return false
    }
  }

  true
}

isNStraightHand(Array(1,2,3,6,2,3,4,7,8), W = 3)
isNStraightHand(Array(1,2,3,4,5), W = 4)