/*
826. Most Profit Assigning Work

jobs:
difficulty[i]
profit[i]

workers.
worker[i] is the ability of the ith worker,
can only complete a job with difficulty at most worker[i].

Every worker can be assigned at most one job,
but one job can be completed multiple times.

For example, if 3 people attempt the same job that pays $1,
then the total profit will be $3.

What is the most profit we can make?


Input: difficulty = [2,4,6,8,10],
profit = [10,20,30,40,50],
worker = [4,5,6,7]
Output: 100
Explanation:
Workers are assigned jobs of difficulty [4,4,6,6]
Get profit of [20,20,30,30] seperately.

1 <= difficulty.length = profit.length <= 10000
1 <= worker.length <= 10000
difficulty[i], profit[i], worker[i]  are in range [1, 10^5]
 */

def maxProfitAssignment(difficulty: Array[Int], profit: Array[Int], worker: Array[Int]): Int = {

  val jobs = difficulty.zip(profit).sortBy(_._1)
  var prevMax = 0

  // an ordered difficult - profit buffer
  val m = collection.mutable.ArrayBuffer[(Int, Int)]()
  for ((diff, prof) <- jobs) {
    if (prof > prevMax) {
      prevMax = prof
      m.append((diff, prof))
    }
  }
  m.append((Integer.MAX_VALUE, 0))


  val ws = worker.sorted
  val l = ws.length

  var i = 0
  var j = 0
  var req = m(0)._1
  var next = m(1)._1
  var money = 0

  // loop through workers
  while (i < l && ws(i) < req) i += 1 // skip retards
  while (i < l) {
    while (i < l && ws(i) < next) {     // assign the jobs
      i += 1
      money += m(j)._2
    }

    if (i < l && ws(i) >= next) {       // fit next job
      j += 1
      req = m(j)._1
      next = m(j + 1)._1
    }
  }

  money
}

maxProfitAssignment(
  Array(2, 4, 6, 8, 10),
  Array(10, 20, 30, 40, 50),
  Array(4, 5, 6, 7)
)