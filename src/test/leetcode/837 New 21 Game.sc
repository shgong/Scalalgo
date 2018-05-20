/*
837. New 21 Game

Alice plays the following game,
loosely based on the card game "21".

Alice starts with 0 points,
and draws numbers while she has <K points.

During each draw,
gains randomly [1, W]

stops when >=K points.
What is the probability of <=N points?

0 <= K <= N <= 10000
1 <= W <= 10000

Example 1:
Input: N = 10, K = 1, W = 10
Output: 1.00000
Explanation:  Alice gets a single card, then stops.
Example 2:

Input: N = 6, K = 1, W = 10
Output: 0.60000
Explanation:  Alice gets a single card, then stops.
In 6 out of W = 10 possibilities, she is at or below N = 6 points.
Example 3:

Input: N = 21, K = 17, W = 10
Output: 0.94823
 */

def new21Game(N: Int, K: Int, W: Int): Double = {
  val x = Array.fill(10001)(0.0)

  // don't assign 1/W
  // 0 0 2 case
  // first split may not happen

  // a rotating probability assigner

  val agg = Array.fill(W+1)(0.0)
  agg(0) = 1.0
  var aggsum = 1.0
  var ind = agg.length

  for(i<- 0 until K){
    x(i) = aggsum

    ind += 1
    if(ind>=W) ind = 0
    aggsum -= agg(ind)
    agg(ind) = x(i) / W
    aggsum += agg(ind)
  }

  for(i<-K to N){
    x(i) = aggsum

    ind += 1
    if(ind>=W) ind = 0
    aggsum -= agg(ind)
  }

  println(x.take(N+1).toList)
  var total = 0.0
  for(i<-K to N) total += x(i)

  total
}


new21Game(0,0,1)
new21Game(0,0,2)
new21Game(1,0,1)
new21Game(10,1,10)
new21Game(6,1,10)
new21Game(21,17,10)