/*
822. Card Flipping Game

On a table are N cards,
with a positive integer printed on the front and back of each card
(possibly different).

We flip any number of cards,
and after we choose one card.

If the number X on the back of the chosen card is not on the front of any card,
then this number X is good.

What is the smallest number that is good?
If no number is good, output 0.

Example:

Input: fronts = [1,2,4,4,7], backs = [1,3,4,1,3]
Output: 2
Explanation: If we flip the second card, the fronts are [1,3,4,4,7] and the backs are [1,2,4,1,3].
We choose the second card, which has number 2 on the back, and it isn't on the front of any card, so 2 is good.
 */

def flipgame(fronts: Array[Int], backs: Array[Int]): Int = {

  val t = Array.fill(2001)(0)
  val len = fronts.length

  val exclude = collection.mutable.Set[Int]()
  val total = collection.mutable.Set[Int]()

  for(i<-0 until len){
    if(fronts(i) == backs(i)) exclude += fronts(i)
    total += fronts(i)
    total += backs(i)

  }


  val res = total -- exclude
  if(res.isEmpty)  0 else  res.toList.min
}

flipgame(Array(1,2,3,4),Array(1,2,3,4))
flipgame(Array(1,2,8,4),Array(1,2,3,4))