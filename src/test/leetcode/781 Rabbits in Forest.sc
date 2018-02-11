/*
In a forest, each rabbit has some color. Some subset of rabbits (possibly all of them) tell you how many other rabbits have the same color as them. Those answers are placed in an array.

Return the minimum number of rabbits that could be in the forest.
 */


def numRabbits(answers: Array[Int]): Int = {
  val res = answers.groupBy(identity)

  var count = res.filter(_._1!=0).map { case (k,v) =>
    (k+1) * ((v.length-1)/(k+1) + 1)
  }.sum

  if(res.contains(0)) count += res(0).length
  count
}

numRabbits(Array(1,2,1))
numRabbits(Array(10,10,10))
numRabbits(Array(0,0,0))
numRabbits(Array(0,0,1,1,1))
numRabbits(Array(1,0,1,0,0))