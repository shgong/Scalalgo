/*
You have n super washing machines on a line.

For each move, you could choose any m (1 ≤ m ≤ n) washing machines,
pass one dress of each washing machine to one of its adjacent washing machines at the same time .

you should find the minimum number of moves to make all the washing machines have the same number of dresses.
If it is not possible to do it, return -1.
 */

def findMinMoves(machines: Array[Int]): Int = {
  val l = machines.length
  if(machines.sum % l != 0 ) return -1
  val target = machines.sum / l

  // find largest continuous moves required
  var agg = 0
  var maxMove = 0
  for (i<- machines) {
    agg += i - target
    maxMove = maxMove max math.abs(agg)
  }

  // find largest single pile move required
  val single = machines.map(_-target).max

  maxMove max single
}

findMinMoves(Array(1,0,5))
findMinMoves(Array(0,3,0))
findMinMoves(Array(0,0,11,5))